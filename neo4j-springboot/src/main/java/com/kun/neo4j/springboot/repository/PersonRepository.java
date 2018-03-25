package com.kun.neo4j.springboot.repository;

import com.kun.neo4j.springboot.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameLike(String name);
}
