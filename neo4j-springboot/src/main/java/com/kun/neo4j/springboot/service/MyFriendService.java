package com.kun.neo4j.springboot.service;

import com.kun.neo4j.springboot.domain.Person;
import com.kun.neo4j.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.CommandLineRunner;

@Service
public class MyFriendService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void doWork() {
        // clean whole and build again
        personRepository.deleteAll();

        Person jon = new Person("Jon");
        Person emil = new Person("Emil");
        Person rod = new Person("Rod");

        System.out.println("at work");
        emil.knows(jon);
        emil.knows(rod);

        // Persist entities and relationships to graph database
        personRepository.save(emil);

        for (Person friend : emil.getFriends()) {
            System.out.println("Friend: " + friend);
        }

    }
}
