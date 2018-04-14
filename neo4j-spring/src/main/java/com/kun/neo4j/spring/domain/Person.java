package com.kun.neo4j.spring.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.NodeEntity;
import com.google.common.collect.Sets;
import java.util.Set;

@JsonInclude
@NodeEntity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Person() {}
    public Person(String name) { this.name = name; }

    @Relationship(type = "FRIEND")
    private Set<Person> friends = Sets.newHashSet();

    public Long getId() { return id; }
    public String getName() { return name; }
    public Set<Person> getFriends() {
        return friends;
    }

    public void knows(Person friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    @Override
    public String toString() {
        return this.name;
    }
}