package com.kun.neo4j.springboot.domain;

import org.neo4j.ogm.annotation.*;

import java.util.Set;


@NodeEntity
public class Movie {

    @Id
    @GeneratedValue
    Long id;
    String title;

    public Movie(String title) {
        this.title = title;
    }

    Person director;

    @Relationship(type="ACTS_IN", direction = Relationship.INCOMING)
    Set<Person> actors;

    //@Relationship(type = "RATED")
    //List<Rating> ratings;
}