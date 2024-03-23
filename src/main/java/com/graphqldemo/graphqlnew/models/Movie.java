package com.graphqldemo.graphqlnew.models;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	public Movie(String title, String director, String studio, Integer releaseYear, List<String> movieCast) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.director=director;
		this.studio=studio;
		this.releaseYear=releaseYear;
		this.movieCast=movieCast;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	private String director;
	private String studio;
	private Integer releaseYear;
	
	@ElementCollection
	@CollectionTable(name="movie_cast")
	private List<String> movieCast;

}
