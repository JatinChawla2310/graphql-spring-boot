package com.graphqldemo.graphqlnew.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphqldemo.graphqlnew.models.Movie;
import com.graphqldemo.graphqlnew.models.MovieInput;
import com.graphqldemo.graphqlnew.service.MovieService;

@Controller
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@QueryMapping
	List<Movie> getAllMoviesHandler() {
		return movieService.getAllMovies();
	}
	
	@MutationMapping
	Movie getMovieByIdHandler(@Argument Integer id) {
		return movieService.getMovieById(id);
	}

	@MutationMapping
	Movie addMovieHandler(@Argument MovieInput movieInput) {
		return movieService.addMovie(movieInput);
	}

	@MutationMapping
	Movie updateMovieHandler(@Argument Integer id, @Argument MovieInput movieInput) {
		return movieService.updateMovie(id, movieInput);
	}
	
	@MutationMapping
	String deleteMovieHandler(@Argument Integer id) {
		return movieService.deleteMovie(id);
	}
}
