package com.graphqldemo.graphqlnew.models;

import java.util.List;

public record MovieInput(String title, String director, String studio, Integer releaseYear, List<String> movieCast) {

}
