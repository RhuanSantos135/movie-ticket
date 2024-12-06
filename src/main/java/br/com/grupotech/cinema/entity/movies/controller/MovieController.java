package br.com.grupotech.cinema.entity.movies.controller;

import br.com.grupotech.cinema.entity.movies.model.Movie;
import br.com.grupotech.cinema.entity.movies.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies") // Updated base URL for clarity
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Retrieve all movies", description = "Fetches all movies from the database.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of movies"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/all") // Route for GET request
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies(); 
    }

    @Operation(summary = "Create a new movie", description = "Adds a new movie to the database.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Movie created successfully"),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping("/create") // Route for POST request
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }
}
