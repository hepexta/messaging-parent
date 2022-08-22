Messaging Parent

# Sample contains two modules:
- activemq-publisher
- activemq-subscriber

The sample is dedicated to ;show an example of working with ActiveMQ.

# Pre-requisites:
 Download and install ActiveMQ 5: apache-activemq-5.17.1

I. Implement publish/subscribe interaction between two applications. Check
durable vs non-durable subscription.

`java -Dserver.port=8083 -jar activemq-subscriber-1.0-SNAPSHOT.jar`