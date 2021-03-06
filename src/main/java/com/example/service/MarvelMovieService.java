package com.example.service;

import com.example.pojo.MarvelPojo;

import java.util.List;

public interface MarvelMovieService {
    public String saveCustomer(MarvelPojo marvelMovies);

    public  boolean deleteMovie(Long movieId) ;

    public List< MarvelPojo > getAllMovies() ;

    public void updateMovie(MarvelPojo marvelPojo);
}
