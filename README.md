# Simple Kafka PoC

Simple Kafka PoC app.

This app creates Kafka, ZooKeeper, and Cassandra instances in Docker. The Java app then connects to the Kafka instance to send and receive messages. Messages are sent to the topic via a REST POST endpoint. 

###Steps
 1. Run ```docker-compuse up docker-file.yml```
 2. Start the app
 4. Put a message on the topic by POSTing to http://localhost:8080/kafka/publish with some text in the body.
 5. Watch the console for the message to be sent and recieved.
 5. Profit!



###Sample POST
```shell
curl --location --request POST 'http://localhost:8080/kafka/publish' \
     --header 'Content-Type: text/plain' \
     --data-raw 'Hello World!'
```

