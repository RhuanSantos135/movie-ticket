package br.com.grupotech.cinema.entity.movies;

import lombok.Data;

@Data
public class MovieDTO {

    private String title;
    private String description;
    private String genre;
    private Integer filmLength;
    private String contentRating;
    private String imageUrl;
    private Double averageRating;

}