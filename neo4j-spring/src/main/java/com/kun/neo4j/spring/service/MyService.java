package com.kun.neo4j.spring.service;

import com.kun.neo4j.spring.domain.Actor;
import com.kun.neo4j.spring.domain.Movie;
import com.kun.neo4j.spring.repository.ActorRepository;
import com.kun.neo4j.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {
    @Autowired
    private ActorRepository actorRepositry;
    private MovieRepository movieRepository;

    @Transactional
    public void doWork() {
        Actor jon  = new Actor("A", "Jon");
        Actor emil = new Actor("B", "Emil");

        Movie wind = new Movie("Wind");

    }

}
