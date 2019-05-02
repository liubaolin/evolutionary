package top.hours.kafka;

import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * 如何新建一个Kafka生产者
 */
public class KafkaProducerSnippet {


    public static void main(String[] args) {
        Properties kafkaProps = new Properties();

        StringSerializer stringSerializer = null;

        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer","")

    }

}
