package br.com.grupotech.cinema.entity.movies;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO toDto(Movie movie);

    Movie toEntity(MovieDTO movieDTO);
}