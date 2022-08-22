Messaging Parent

# Sample contains two modules:
- activemq-publisher
- activemq-subscriber

The sample is dedicated to ;show an example of working with ActiveMQ.

# Pre-requisites:
 Download and install ActiveMQ 5: apache-activemq-5.17.1

# Tasks
I. Implement publish/subscribe interaction between two applications. Check durable vs non-durable subscription.

`java -Dserver.port=8081 -jar activemq-publisher-1.0-SNAPSHOT.jar`

`java -Dserver.port=8082 -jar activemq-subscriber-1.0-SNAPSHOT.jar`

`java -Dserver.port=8083 -jar activemq-durable-subscriber-1.0-SNAPSHOT.jar`

`POST http://localhost:8081/messages/addToQueue {"message": "hello world"}`
`POST http://localhost:8081/messages/addToTopic {"message": "hello world"}`
`POST http://localhost:8081/messages/addToDurableTopic {"message": "hello world"}`

II. Implement request-reply interaction between two applications using a temporary queue in ActiveMQ.


III. Implement subscriber scaling, i.e. create n subscribers to a topic with the same ClientID (see Virtual Topics in ActiveMQ)

Run the publisher

`java -Dserver.port=8081 -jar activemq-publisher-1.0-SNAPSHOT.jar`

Run two subscribers

`java -Dserver.port=8082 -jar activemq-subscriber-1.0-SNAPSHOT.jar`

`java -Dserver.port=8083 -jar activemq-subscriber-1.0-SNAPSHOT.jar`

Post a message to the topic

`POST http://localhost:8081/messages/addToTopic {"message": "hello world"}`