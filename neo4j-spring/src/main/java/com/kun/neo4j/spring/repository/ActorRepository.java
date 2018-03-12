package com.kun.neo4j.spring.repository;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.kun.neo4j.spring.domain.Actor;

public interface ActorRepository extends Neo4jRepository<Actor, Long> {
}
