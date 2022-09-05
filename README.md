Messaging Parent

# Sample contains two modules:
- activemq-publisher
- activemq-subscriber
- activemq-durable-subscriber
- activemq-request-reply

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

Module activemq-request-reply has an example of request-reply pattern.
The message is generating inside the main method. And the Receiver class is replying on it.

`java -Dserver.port=8085 -jar activemq-request-reply-1.0-SNAPSHOT.jar`

III. Implement subscriber scaling, i.e. create n subscribers to a topic with the same ClientID (see Virtual Topics in ActiveMQ)

Run the publisher

`java -Dserver.port=8081 -jar activemq-publisher-1.0-SNAPSHOT.jar`

Run two subscribers

`java -Dserver.port=8082 -jar activemq-subscriber-1.0-SNAPSHOT.jar`

`java -Dserver.port=8083 -jar activemq-subscriber-1.0-SNAPSHOT.jar`

Post a message to the topic

`POST http://localhost:8081/messages/addToQueue {"message": "hello world 1"}`

`POST http://localhost:8081/messages/addToQueue {"message": "hello world 2"}`

`POST http://localhost:8081/messages/addToQueue {"message": "hello world 3"}`

`POST http://localhost:8081/messages/addToQueue {"message": "hello world 4"}`

`POST http://localhost:8081/messages/addToTopic {"message": "hello world topic"}`

`POST http://localhost:8081/messages/addToVirtualTopic {"message": "hello world virtual topic 1"}`

`POST http://localhost:8081/messages/addToVirtualTopic {"message": "hello world virtual topic 2"}`

Messages for queue consumed in Round Robin, messages for topic consumed by both instances.

![instance&nbsp;1.PNG](instance&nbsp;1.PNG)
![instance&nbsp;2.PNG](instance&nbsp;2.PNG)
