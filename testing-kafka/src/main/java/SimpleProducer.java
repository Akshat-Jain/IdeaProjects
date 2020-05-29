import java.util.*;
import org.apache.kafka.clients.producer.*;
public class SimpleProducer {

    public static void main(String[] args) throws Exception{

        String topicName = "MySecondTopic";
        String key = "Key1";
        String value = "Value1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName,key,value);
        producer.send(record);
        producer.close();

        System.out.println("SimpleProducer Completed.");
    }
}