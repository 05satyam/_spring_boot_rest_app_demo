package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.MarvelPojo;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MarvelController {
    private static Map<String, MarvelPojo> marvelMovies = new HashMap<>();
    static {
        MarvelPojo honey = new MarvelPojo();
        honey.setId("1");
        honey.setName("Avenger");
        honey.setSequalNumber("1");
        marvelMovies.put(honey.getId(), honey);

        MarvelPojo honeyLove = new MarvelPojo();
        honeyLove.setId("1");
        honeyLove.setName("Avenger");
        honeyLove.setSequalNumber("Age of ultron");
        marvelMovies.put(honey.getId(), honeyLove);

        MarvelPojo honeyLoveAgain = new MarvelPojo();
        honeyLoveAgain.setId("1");
        honeyLoveAgain.setName("Avenger");
        honeyLoveAgain.setSequalNumber("Infinity war");
        marvelMovies.put(honey.getId(), honeyLoveAgain);
    }

    @RequestMapping(value = "/movieList")
    public ResponseEntity<Object> getMarvelList() {
        return new ResponseEntity<>(marvelMovies.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public ResponseEntity<Object> enterNewMovie(@RequestBody MarvelPojo product) {
        marvelMovies.put(product.getId(), product);
        return new ResponseEntity<>("Movie added in list successfully", HttpStatus.CREATED);
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
        return new ResponseEntity<>("Movie is deleted successsfully", HttpStatus.OK);
    }
}
