package com.kun;

/**
 * @author: jzhangkun
 * @since: 1.0
 */

// Download Java Driver: http://search.maven.org/#artifactdetails|org.neo4j.driver|neo4j-java-driver|1.0.0|jar

import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;

import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonMap;

public class BlankSandbox {

    public static void main(String...args) {
        Config noSSL = Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig();
        Driver driver = GraphDatabase.driver("bolt://54.209.118.95:34347",AuthTokens.basic("neo4j","boresight-house-policies"),noSSL); // <password>
        try (Session session = driver.session()) {
            String cypherQuery =
                "MATCH (n) " +
                    "RETURN id(n) AS id";
            StatementResult result = session.run(cypherQuery, parameters());
            while (result.hasNext()) {
                System.out.println(result.next().get("id"));
            }
        }
    }
}
