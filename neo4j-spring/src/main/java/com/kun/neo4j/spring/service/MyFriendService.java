package com.kun.neo4j.spring.service;

import com.kun.neo4j.spring.domain.Person;
import com.kun.neo4j.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyFriendService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void doWork() {

        Person jon  = new Person("Jon");
        Person emil = new Person("Emil");
        Person rod  = new Person("Rod");

        emil.knows(jon);
        emil.knows(rod);

        // Persist entities and relationships to graph database
        personRepository.save(emil);

        for (Person friend : emil.getFriends()) {
            System.out.println("Friend: " + friend);
        }

        // Control loading depth
        //Person thatSamejon = personRepository.findOne(id, 2);
        for (Person friend : jon.getFriends()) {
            System.out.println("Jon's friends to depth 2: " + friend);
        }
    }
}
