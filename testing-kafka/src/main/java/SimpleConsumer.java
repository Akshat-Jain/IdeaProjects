import java.util.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.*;

public class SimpleConsumer{

    public static void main(String[] args) throws Exception{

        String topicName = "MySecondTopic";
        KafkaConsumer<String, String> consumer = null;

        String groupName = "ak";
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", groupName);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<String, String>(props);
        String[] topicNames = {topicName};
        consumer.subscribe(Arrays.asList(topicNames));
        try{
            while (true){
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records){
//                    System.out.println("Topic:"+ record.topic() +" Partition:" + record.partition() + " Offset:" + record.offset() + " Value:"+ record.value());
                    System.out.println("Topic:"+ record.topic() +" Partition:" + record.partition() +  " Key:"+ record.key() + " Value:"+ record.value());
//                    System.out.println(" Value:"+ record.value());
                    // Do some processing and save it to Database
//                    rebalanceListner.addOffset(record.topic(), record.partition(),record.offset());
                }
                //consumer.commitSync(rebalanceListner.getCurrentOffsets());
            }
        }catch(Exception ex){
            System.out.println("Exception.");
            ex.printStackTrace();
        }
        finally{
            consumer.close();
        }
    }

}