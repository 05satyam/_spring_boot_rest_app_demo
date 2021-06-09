package com.example.service.impl;

import com.example.dao_repo.CustomRepository;
import com.example.entity.MarvelMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pojo.MarvelPojo;
import com.example.service.MarvelMovieService;

import java.util.ArrayList;
import java.util.List;

@Service("marvelMovieService")
public class MarvelMovieServiceImpl implements MarvelMovieService {
    @Autowired
    private CustomRepository customRepository;


    @Override
    public String saveCustomer(MarvelPojo marvelMoviesObjReq) {
        MarvelMovies marvelMoviesDb = new MarvelMovies();
        marvelMoviesDb.setSequalNumber(marvelMoviesObjReq.getSequalNumber());
        marvelMoviesDb.setName(marvelMoviesObjReq.getName());
        marvelMoviesDb.setId(Long.valueOf(marvelMoviesObjReq.getId()));
        MarvelMovies savedObj = customRepository.save(marvelMoviesDb);
        return savedObj!=null? "data saved successfully": null;
    }

    @Override
    public boolean deleteMovie(Long movieId) {
        customRepository.deleteById(movieId);
        return true;
    }

    @Override
    public List<MarvelPojo> getAllMovies() {
        List<MarvelMovies> dbMarvelMoviesList = customRepository.findAll();
        List<MarvelPojo> marvelReponseList = new ArrayList<>();
        dbMarvelMoviesList.forEach(marvelMovies -> marvelReponseList.add(populateMarvelPojoObj(marvelMovies)));
        return marvelReponseList;
    }

    @Override
    public void updateMovie(MarvelPojo marvelPojo) {
       ;
    }

    private MarvelPojo populateMarvelPojoObj(MarvelMovies marvelMovies){
        MarvelPojo marvelPojo = new MarvelPojo();
        marvelPojo.setId(String.valueOf(marvelMovies.getId()));
        marvelPojo.setName(marvelMovies.getName());
        marvelPojo.setSequalNumber(marvelMovies.getSequalNumber());
        return marvelPojo;
    }
}
