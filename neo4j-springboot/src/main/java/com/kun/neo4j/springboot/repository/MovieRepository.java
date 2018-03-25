package com.kun.neo4j.springboot.repository;
import com.kun.neo4j.springboot.domain.Movie;
import com.kun.neo4j.springboot.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {


    /*
    // derived finder
    Movie findByTitle(String title);

    //@Query("MATCH (m:Movie)<-[rating:RATED]-(user) WHERE id(movie)={movie} return rating")
    //List<Rating> getRatings(@Param("movie") Movie movie);

    // Co-Actors
    Set<Person> findByActorsMoviesActorName(String name);

    @Query("MATCH (movie:Movie)-[:HAS_GENRE]->(genre)<-[:HAS_GENRE]-(similar) WHERE id(movie) = {0} RETURN similar")
    List<Movie> findSimilarMovies(Movie movie);
    */
}

