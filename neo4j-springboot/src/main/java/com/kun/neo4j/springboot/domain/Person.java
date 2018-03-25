package com.kun.neo4j.springboot.domain;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Person {
    private Long id;
    private String name;

    public Person() {}
    public Person(String name) { this.name = name; }

    @Relationship(type = "FRIEND", direction = "OUTGOING")
    private Set<Person> friends = new HashSet<Person>();

    public Set<Person> getFriends() {
        return friends;
    }

    public void knows(Person friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }
}