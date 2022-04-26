package org.acme;

import io.smallrye.graphql.federation.api.Extends;
import io.smallrye.graphql.federation.api.External;
import io.smallrye.graphql.federation.api.Key;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

@Extends
@Key(fields = "movieId")
public class Movie {

    @External @NonNull @Id
    public String movieId;

    @External @NonNull
    public String title;

    public Movie(String movieId) {
        this.movieId = movieId;
    }

    public Movie() {
    }
}
