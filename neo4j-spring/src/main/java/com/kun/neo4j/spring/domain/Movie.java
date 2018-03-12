package com.kun.neo4j.spring.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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