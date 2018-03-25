package com.kun.neo4j.springboot.repository;

import com.kun.neo4j.springboot.domain.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {
}
