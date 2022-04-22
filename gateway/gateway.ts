const { ApolloServer } = require('apollo-server');
const { ApolloGateway, IntrospectAndCompose } = require('@apollo/gateway');

const gateway = new ApolloGateway({
  supergraphSdl: new IntrospectAndCompose({
    subgraphs: [
        { name: 'movie', url: 'http://localhost:8081/graphql' },
        { name: 'production', url: 'http://localhost:8082/graphql' },
        // ...additional subgraphs...
    ],
  }),
});

const server = new ApolloServer({
    gateway,
    subscriptions: false,
});

server.listen().then(({ url } : {url:any}) => {
    console.log(`🚀 Gateway ready at ${url}`);
});
