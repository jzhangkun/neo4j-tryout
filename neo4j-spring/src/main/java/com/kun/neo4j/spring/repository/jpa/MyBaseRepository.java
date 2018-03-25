package com.kun.neo4j.spring.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface MyBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
