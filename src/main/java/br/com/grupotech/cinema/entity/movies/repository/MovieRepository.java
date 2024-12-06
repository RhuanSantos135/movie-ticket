package br.com.grupotech.cinema.entity.movies.repository;

import br.com.grupotech.cinema.entity.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {  
    
}
