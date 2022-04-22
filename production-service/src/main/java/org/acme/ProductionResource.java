package org.acme;

import io.smallrye.graphql.federation.api.FederatedSource;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GraphQLApi
public class ProductionResource {

    @Inject
    MovieClient movieClient;

    private static final Map<String, List<Production>> PRODUCTIONS = new HashMap<>();

    static {
        Production p1 = new Production("1", "Sony Pictures", "1");
        Production p2 = new Production("2", "MGM", "2");
        Production p3 = new Production("3", "Netflix", "3");
        Production p4 = new Production("4", "Studio69", "3");
        PRODUCTIONS.put("1", new ArrayList<Production>() {
            {
                add(p1);
            }
        });
        PRODUCTIONS.put("2", new ArrayList<Production>() {
            {
                add(p2);
            }
        });
        PRODUCTIONS.put("3", new ArrayList<Production>() {
            {
                add(p3);
                add(p4);
            }
        });
    }

    @Query
    public List<Production> productions(@FederatedSource Movie movie) {
        List<Production> productions = PRODUCTIONS.computeIfAbsent(movie.movieId, key -> new ArrayList<>());
        Movie m = movieClient.getMovie(movie.movieId);
        productions.stream().forEach(p -> { p.movies = new ArrayList<>(); p.movies.add(m); });
        return productions;
    }

}
