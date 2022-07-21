# Getting Started

### Pre-requisites
This project needs kafka and java 8 to be installed locally
### Some useful Kafka commands

bin/zookeeper-server-start.sh config/zookeeper.properties

bin/kafka-server-start.sh config/server.properties

bin/kafka-console-consumer.sh --topic ather-events --from-beginning --bootstrap-server localhost:9092

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic ather-events

#### Note: ather-events is a topic name in the above commands as temporarily hard coded in the code