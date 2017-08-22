package com.kun.config;
import org.neo4j.*;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class GraphDB {

    public static GraphDatabaseService
    GraphDatabaseSettings.BoltConnector bolt = GraphDatabaseSettings.boltConnector( "0" );

    GraphDatabaseService graphDb = new GraphDatabaseFactory()
        .newEmbeddedDatabaseBuilder( DB_PATH )
        .setConfig( bolt.type, "BOLT" )
        .setConfig( bolt.enabled, "true" )
        .setConfig( bolt.address, "localhost:7687" )
        .newGraphDatabase();
}
