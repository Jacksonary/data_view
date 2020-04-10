package com.glodon.data_view.service;

import java.util.concurrent.TimeUnit;

//import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.alibaba.fastjson.JSON;
import com.glodon.data_view.bean.Message;

/**
 * @author liuwg-a
 * @date 2019/12/10 19:02
 * @description
 */
@Service("producer")
public class KafkaProducer {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//    @Autowired
//    private NewTopic                      noBlockingSpringKafkaTopic;
//    @Autowired
//    private NewTopic                      blockingSpringKafkaTopic;

    private static final Logger           logger = LoggerFactory.getLogger(KafkaProducer.class);

    /**
     * 1. 异步非阻塞发送消息
     * 
     * @param message message
     */
    public void noBlockingSend(Message message) {
        if (message == null) {
            return;
        }

//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(noBlockingSpringKafkaTopic.name(),
//                                                                                 JSON.toJSONString(message));
//        /*
//         * 消息发送成功进行回调
//         */
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//
//            @Override
//            public void onFailure(Throwable throwable) {
//                // 处理失败的逻辑
//                logger.error("kafka producer：send message failed");
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, String> stringStringSendResult) {
//                // 处理成功的逻辑
//                logger.info("kafka producer： send message success");
//            }
//        });
    }

    /**
     * 2. 阻塞式发送消息
     * 
     * @param message message
     */
    public void blockingSend(Message message) {
        try {
//            kafkaTemplate.send(blockingSpringKafkaTopic.name(), JSON.toJSONString(message)).get(5, TimeUnit.SECONDS);
            // 发送成功立即处理
            logger.info("kafka producer： send message success");
        } catch (Exception e) {
            // 处理失败的逻辑
            logger.error("kafka producer：send message failed");
        }
    }

}
