package com.example.crudspringichsan.controller;

import com.example.crudspringichsan.exception.ResourceNotFoundException;
import com.example.crudspringichsan.model.Movie;
import com.example.crudspringichsan.repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie tidak tersedia dengan id = " + id));
        return ResponseEntity.ok(movie);
    }
}
