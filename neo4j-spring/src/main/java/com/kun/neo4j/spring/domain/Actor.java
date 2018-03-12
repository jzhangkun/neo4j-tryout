package com.kun.neo4j.spring.domain;
import org.neo4j.ogm.annotation.*;

@NodeEntity
public class Actor {

    @Id
    @GeneratedValue
    private Long nodeId;
    String id;
    String name;

    public Actor() {
    }

    public Actor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}