package br.com.grupotech.cinema.entity.movies;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public MovieDTO saveMovie(MovieDTO movieDTO) {
        Movie movie = movieMapper.toEntity(movieDTO);
        movie = movieRepository.save(movie);
        return movieMapper.toDto(movie);
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movieMapper::toDto)
                .toList();
    }

    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID: " + id));
        return movieMapper.toDto(movie);
    }

    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID: " + id));

        // Update all fields dynamically
        updateFields(existingMovie, movieDTO, true);

        Movie updatedMovie = movieRepository.save(existingMovie);
        return movieMapper.toDto(updatedMovie);
    }

    public MovieDTO partiallyUpdateMovie(Long id, MovieDTO movieDTO) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID: " + id));

        // Update only non-null fields dynamically
        updateFields(existingMovie, movieDTO, false);

        Movie updatedMovie = movieRepository.save(existingMovie);
        return movieMapper.toDto(updatedMovie);
    }

    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found with ID: " + id);
        }
        movieRepository.deleteById(id);
    }

    private void updateFields(Object target, Object source, boolean overwrite) {
        Field[] fields = source.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object newValue = field.get(source);

                if (overwrite || newValue != null) {
                    Field targetField = target.getClass().getDeclaredField(field.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, newValue);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.err.println("Failed to update field: " + field.getName() + " - " + e.getMessage());
            }
        }
    }
}