package com.glodon.data_view.service;

import java.util.Optional;

//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author liuwg-a
 * @date 2019/12/10 19:04
 * @description
 */
@Service("consumer")
public class KafkaConsumer {

    private static final String NO_BLOCKING_SPRING_KAFKA_TOPIC_STR = "spring-kafka-no-blocking-test";
    private static final String BLOCKING_SPRING_KAFKA_TOPIC_STR    = "spring-kafka-blocking-test";

    private static final Logger logger                             = LoggerFactory.getLogger(KafkaConsumer.class);

    /**
     * 注解 @KafkaListener 会促使 Spring Kafka 自动创建一个消息容器
     */
//    @KafkaListener(topics = NO_BLOCKING_SPRING_KAFKA_TOPIC_STR, groupId = NO_BLOCKING_SPRING_KAFKA_TOPIC_STR)
//    public void receiveNoBlocking(ConsumerRecord<String, String> record) {
//        Optional<String> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            logger.info("kafka consumer： receive message -> record = {}", record);
//            logger.info("kafka consumer： receive message -> message = {}", message);
//        }
//
//    }
//
//    @KafkaListener(topics = BLOCKING_SPRING_KAFKA_TOPIC_STR, groupId = BLOCKING_SPRING_KAFKA_TOPIC_STR)
//    public void receiveBlocking(ConsumerRecord<String, String> record) {
//        Optional<String> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            logger.info("kafka consumer： receive message -> record = {}", record);
//            logger.info("kafka consumer： receive message -> message = {}", message);
//        }
//    }

}
