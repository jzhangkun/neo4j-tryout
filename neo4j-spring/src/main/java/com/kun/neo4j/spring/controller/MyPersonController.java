package com.kun.neo4j.spring.controller;

import com.kun.neo4j.spring.domain.Person;
import com.kun.neo4j.spring.repository.PersonRepository;
import com.kun.neo4j.spring.service.MyFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/person")
public class MyPersonController {
    Logger logger = Logger.getLogger(MyPersonController.class.getName());
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String WelcomeHome() {
        return "Welcome to my Person page";
    }

    @ResponseBody
    @RequestMapping(value = "/name/{name}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person findPersonByName(@PathVariable("name") String name) {
        Person person = personRepository.findByName(name);
        logger.info("find Person: " + person);
        return personRepository.findByName(name);
    }

}
