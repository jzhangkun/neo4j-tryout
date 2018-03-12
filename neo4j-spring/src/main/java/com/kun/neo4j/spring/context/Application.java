package com.kun.neo4j.spring.context;
import com.kun.neo4j.spring.service.MyFriendService;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.kun.neo4j.spring")
@EnableNeo4jRepositories(basePackages = "com.kun.neo4j.spring.repository")
public class Application {

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(configuration(),"com.kun.neo4j.spring.domain");
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
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MyFriendService myFriendService = context.getBean(MyFriendService.class);
        myFriendService.doWork();
    }
}
