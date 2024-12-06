package br.com.grupotech.cinema.entity.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String genre;
    private Integer length;
    private String indicativeRating;
    private String imageUrl;
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