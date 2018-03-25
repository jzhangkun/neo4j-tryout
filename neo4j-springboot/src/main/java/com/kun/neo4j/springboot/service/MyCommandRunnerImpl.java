package com.kun.neo4j.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandRunnerImpl implements CommandLineRunner {

    @Autowired
    MyFriendService myFriendService;

    @Override
    public void run(String... vars) throws Exception {
        System.out.println("Running friend service");
        myFriendService.doWork();
    }
}
