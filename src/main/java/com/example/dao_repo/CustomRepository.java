package com.example.dao_repo;

import com.example.entity.MarvelMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository extends JpaRepository<MarvelMovies,Long> { }