package br.com.grupotech.cinema.entity.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(description = "Represents a Movie entity.")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Exclude from POST request
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Unique identifier of the movie, auto-generated.")
    private Long id;

    @Schema(description = "Title of the movie.", example = "Inception")
    private String title;

    @Schema(description = "Description of the movie.", example = "A thief with the ability to enter dreams...")
    private String description;

    @Schema(description = "Genre of the movie.", example = "Sci-Fi")
    private String genre;

    @Schema(description = "Length of the movie in minutes.", example = "148")
    private Integer length;

    @Schema(description = "Indicative rating of the movie.", example = "PG-13")
    private String indicativeRating;

    @Schema(description = "URL of the movie poster image.", example = "http://example.com/image.jpg")
    private String imageUrl;

    @Schema(description = "Average rating of the movie.", example = "8.8")
    private Double averageRate;

    public Movie() {}

    public Movie(String title, String description, String genre, Integer length, 
                 String indicativeRating, String imageUrl, Double averageRate) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.length = length;
        this.indicativeRating = indicativeRating;
        this.imageUrl = imageUrl;
        this.averageRate = averageRate;
    }
}
