package org.acme;

import io.smallrye.graphql.federation.api.Extends;
import io.smallrye.graphql.federation.api.External;
import io.smallrye.graphql.federation.api.Key;
import org.eclipse.microprofile.graphql.NonNull;

@Extends
@Key(fields = "movieId")
public class Movie {

    @External @NonNull
    public String movieId;

    @External
    public String title;

    public Movie(String movieId) {
        this.movieId = movieId;
    }

    public Movie() {
    }
}
