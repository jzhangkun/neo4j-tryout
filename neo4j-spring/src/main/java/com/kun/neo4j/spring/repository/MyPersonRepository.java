package com.kun.neo4j.spring.repository;

import com.kun.neo4j.spring.domain.Person;

public interface MyPersonRepository extends MyBaseRepository<Person, Long> {
    Person findByName(String name);
}
