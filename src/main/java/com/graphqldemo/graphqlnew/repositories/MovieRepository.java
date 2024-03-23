package com.graphqldemo.graphqlnew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphqldemo.graphqlnew.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
