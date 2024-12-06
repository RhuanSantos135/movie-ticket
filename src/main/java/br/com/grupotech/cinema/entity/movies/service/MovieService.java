package br.com.grupotech.cinema.entity.movies.service;

import br.com.grupotech.cinema.entity.movies.model.Movie;
import br.com.grupotech.cinema.entity.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

   
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    
    public List<Movie> getAllMovies() {
       
        return movieRepository.findAll();  
    }

    
    public Movie createMovie(Movie movie) {
   
        return movieRepository .save(movie);  
    }
}
