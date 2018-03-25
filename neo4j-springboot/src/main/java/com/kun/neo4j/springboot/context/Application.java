package com.kun.neo4j.springboot.context;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.kun.neo4j.springboot")
@EnableNeo4jRepositories(basePackages = "com.kun.neo4j.springboot.repository")
@EntityScan("com.kun.neo4j.springboot.domain")
public class Application {

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(configuration(),"com.kun.neo4j.springboot.domain");// with com.kun.neo4j.springboot.domain entity base package(s)
    }

    @Bean
    public Neo4jTransactionManager transactionManager() throws Exception {
        return new Neo4jTransactionManager(getSessionFactory());
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new org.neo4j.ogm.config.Configuration.Builder()
                .uri("bolt://localhost:7687")
                .credentials("neo4j","neo4jadmin")
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
