package com.kun.neo4j.hello;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person findByName(String name);
}
