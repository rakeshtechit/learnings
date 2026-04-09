# Kafka commands
cd /opt/kafka/bin
./kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
./kafka-topics.sh --list --bootstrap-server localhost:9092
./kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
./kafka-topics.sh --alter --topic quickstart-events --bootstrap-server localhost:9092 --partitions 2
./kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092


# Test Sending and Receiving messages
./kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
./kafka-console-consumer.sh --topic quickstart-events --bootstrap-server localhost:9092

./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list


./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group my_group 
                      --topic quickstart-events:0 \
                      --reset-offsets \
                      --to-offset 500 \
                      --execute