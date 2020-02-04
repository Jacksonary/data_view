package com.glodon.data_view.service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.glodon.data_view.bean.Message;

/**
 * @author liuwg-a
 * @date 2019/12/12 20:41
 * @description
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class KafkaProducerTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    void noBlockingSend() {
        for (int i = 0; i < 1; i++) {
            kafkaProducer.noBlockingSend(produceMessage());
        }
    }

    @Test
    void blockingSend() {
        for (int i = 0; i < 1; i++) {
            kafkaProducer.blockingSend(produceMessage());
        }
    }

    private Message produceMessage() {
        return new Message(new Random().nextLong(), UUID.randomUUID().toString(), LocalDateTime.now());
    }

}
