package com.kun.client;

// Download Java Driver: http://search.maven.org/#artifactdetails|org.neo4j.driver|neo4j-java-driver|1.0.0|jar

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * @author: jzhangkun
 * @since: 1.0
 */

public class LocalBlankSandbox {

    public static void main(String...args) {
        Config noSSL = Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig();
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",AuthTokens.basic("neo4j","Jz123456"),noSSL); // <password>
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
