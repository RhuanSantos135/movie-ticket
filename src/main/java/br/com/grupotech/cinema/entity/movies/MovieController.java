package br.com.grupotech.cinema.entity.movies;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@Tag(name = "Items", description = "Item management APIs")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @Operation(summary = "Get all items")
    public List<MovieDTO> getAllItems() {
        return movieService.getAllMovies();
    }

    @PostMapping
    @Operation(summary = "Create a new item")
    public MovieDTO createMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.saveMovie(movieDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get item by ID")
    public MovieDTO getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing item")
    public MovieDTO updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        return movieService.updateMovie(id, movieDTO);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Partially update an existing item")
    public MovieDTO partiallyUpdateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        return movieService.partiallyUpdateMovie(id, movieDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an item by ID")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
