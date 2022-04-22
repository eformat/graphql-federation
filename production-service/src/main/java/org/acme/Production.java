package org.acme;

import io.smallrye.graphql.api.federation.External;
import io.smallrye.graphql.api.federation.Key;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

import java.util.List;

@Key(fields = "productionId")
public class Production {

    public @NonNull @Id String productionId;

    public @NonNull String vendor;

    public List<Movie> movies;

    public String movieId;

    public Production(String productionId, String vendor, String movieId) {
        this.productionId = productionId;
        this.vendor = vendor;
        this.movieId = movieId;
    }

    public Production() {
    }
}
