package com.kun.neo4j.spring.domain;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Person() {}
    public Person(String name) { this.name = name; }

    @Relationship(type = "FRIEND")
    private Set<Person> friends = new HashSet<Person>();

    public Set<Person> getFriends() {
        return friends;
    }

    public void knows(Person friend) { friends.add(friend); }
}