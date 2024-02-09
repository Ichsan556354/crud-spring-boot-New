package com.example.crudspringichsan;

import com.example.crudspringichsan.model.Movie;
import com.example.crudspringichsan.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApi354Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestApi354Application.class, args);
	}
        
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        Movie movie = new Movie();
        movie.setTitle("Pengabdi Setan");
        movie.setYear(2016);
        movie.setRating(7);
        movie.setViewer("250K");
        movieRepository.save(movie);
        
        Movie movie1 = new Movie();
        movie1.setTitle("Dilan");
        movie1.setYear(2016);
        movie1.setRating(9);
        movie1.setViewer("880K");
        movieRepository.save(movie1);
    }
    
    
}
