package org.acme;

import io.smallrye.graphql.federation.api.Key;
import org.eclipse.microprofile.graphql.NonNull;

@Key(fields = "movieId")
public class Movie {

    @NonNull public String movieId;
    @NonNull public String title;

    public Movie(String movieId, String title) {
        this.movieId = movieId;
        this.title = title;
    }
}
