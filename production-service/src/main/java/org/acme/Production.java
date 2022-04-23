package org.acme;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

import java.util.List;

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
