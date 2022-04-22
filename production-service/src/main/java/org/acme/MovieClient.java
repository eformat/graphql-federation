package org.acme;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;

@GraphQLClientApi(configKey = "movie-client", endpoint = "http://localhost:8081/graphql")
public interface MovieClient {

    public Movie getMovie(String movieId);

}
