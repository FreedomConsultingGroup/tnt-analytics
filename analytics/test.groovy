TransportClient client = TransportClient.builder().settings(Settings.settingsBuilder {
  client.transport.sniff = true
  cluster.name = "your-cluster-name"
}).build()

// identical to the Java client:
client.addTransportAddress( ... )

//String userId = "some-user-id"

// asynchronously fetch the results
ListenableActionFuture<SearchResponse> future = client.searchAsync {
  indices "your-index"
  types "your-type"
  source {
    query {
      match {
        user.id = userId
      }
    }
  }
}
