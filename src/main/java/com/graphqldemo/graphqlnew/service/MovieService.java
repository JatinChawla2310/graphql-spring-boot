package com.graphqldemo.graphqlnew.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphqldemo.graphqlnew.exception.MovieNotFoundException;
import com.graphqldemo.graphqlnew.models.Movie;
import com.graphqldemo.graphqlnew.models.MovieInput;
import com.graphqldemo.graphqlnew.repositories.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(Integer id) {
		return movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("Movie with given id does not exist!"));
	}
	
	public Movie addMovie(MovieInput movieInput) {
		Movie movie = new Movie(movieInput.title(),movieInput.director(),movieInput.studio(),movieInput.releaseYear(),movieInput.movieCast());
		return movieRepository.save(movie);
	}
	
	public Movie updateMovie(Integer id, MovieInput movieInput) {
		Movie movie = movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("Movie with given id does not exist!"));
		movie.setTitle(movieInput.title());
		movie.setDirector(movieInput.director());
		movie.setStudio(movieInput.studio());
		movie.setReleaseYear(movieInput.releaseYear());
		movie.setMovieCast(movieInput.movieCast());
		return movieRepository.save(movie);		
	}
	
	public String deleteMovie(Integer id) {
		Movie movie = movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("Movie with given id does not exist!"));
		movieRepository.delete(movie);
		return "Movie with mentioned id deleted successfully!";
	}
}
