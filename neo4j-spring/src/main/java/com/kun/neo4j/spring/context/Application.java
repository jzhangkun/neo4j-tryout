package com.kun.neo4j.spring.context;
import com.kun.neo4j.spring.service.MyFriendService;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
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
        ConfigurationSource properties = new ClasspathConfigurationSource("ogm.properties");
        return new org.neo4j.ogm.config.Configuration.Builder(properties).build();
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MyFriendService myFriendService = context.getBean(MyFriendService.class);
        myFriendService.doWork();
    }
}
