package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.MarvelPojo;
import service.MarvelMovieService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MarvelController {

    @Autowired
    MarvelMovieService marvelMovieService;

    private static Map<String, MarvelPojo> marvelMovies = new HashMap<>();
    static {
        MarvelPojo honey = new MarvelPojo();
        honey.setId("1");
        honey.setName("Avenger");
        honey.setSequalNumber("1");
        marvelMovies.put(honey.getId(), honey);

        MarvelPojo honeyLove = new MarvelPojo();
        honeyLove.setId("2");
        honeyLove.setName("Avenger");
        honeyLove.setSequalNumber("Age of ultron");
        marvelMovies.put(honeyLove.getId(), honeyLove);

        MarvelPojo honeyLoveAgain = new MarvelPojo();
        honeyLoveAgain.setId("3");
        honeyLoveAgain.setName("Avenger");
        honeyLoveAgain.setSequalNumber("Infinity war");
        marvelMovies.put(honeyLoveAgain.getId(), honeyLoveAgain);
    }

    @RequestMapping(value = "/movieList")
    public ResponseEntity<Object> getMarvelList() {

        return new ResponseEntity<>(marvelMovieService.getAllMovies(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public ResponseEntity<Object> enterNewMovie(@RequestBody MarvelPojo product) {
        marvelMovies.put(product.getId(), product);
        String updateMovie = marvelMovieService.saveCustomer(product);

        return new ResponseEntity<>(updateMovie!=null? updateMovie: null, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateMovie/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody MarvelPojo marvelPojo) {
        marvelMovies.remove(id);
        marvelPojo.setId(id);
        marvelMovies.put(id, marvelPojo);
        return new ResponseEntity<>("Movie is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteMovie/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        marvelMovies.remove(id);
        boolean deleted = marvelMovieService.deleteMovie(Long.valueOf(id));
        return new ResponseEntity<>(String.valueOf(deleted), HttpStatus.OK);
    }
}
