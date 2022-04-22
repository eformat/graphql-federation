package org.acme;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GraphQLApi
public class MovieResource {

    private static final Map<String, Movie> MOVIES = new HashMap<>();

    static {
        MOVIES.put("1", new Movie("1", "The Shawshank Redemption"));
        MOVIES.put("2", new Movie("2", "Batman Returns"));
        MOVIES.put("3", new Movie("3", "Spiderman"));
    }

    @Query("allMovies")
    public List<Movie> getAllMovies() {
        return new ArrayList<>(MOVIES.values());
    }

    @Query("movie")
    public Movie getMovie(String movieId) {
        // and in your query method:
        return MOVIES.get(movieId);
    }

}



