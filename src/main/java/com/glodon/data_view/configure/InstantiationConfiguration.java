package com.glodon.data_view.configure;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.bimface.sdk.BimfaceClient;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author liuwg-a
 * @date 2019/1/4 15:49
 * @description 实例化配置
 */
@Configuration
public class InstantiationConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(InstantiationConfiguration.class);

    @Bean("myThreadPool")
    public ThreadPoolExecutor initMyThreadPool() {
        return new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),
                                      new MyThreadFactoryBuilder().namePrefix("data-view").build());
    }

    @Bean(name = "bimfaceClient")
    public BimfaceClient bimfaceClient() {
        return new BimfaceClient("lurBMVMFuy4fGiWiSWeCk6ee8B1KuEgZ", "08r7Somr3zHArXLqkf74tcCySBKYN7Dv");
    }

    /**
     * 自定义Redis的序列化方式
     * 
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer(StandardCharsets.UTF_8);
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(new FastJsonRedisSerializer<>(Map.class));

        return template;
    }

    /**
     * 创建一个测试的 topic
     *
     * @return NewTopic
     */
    @Bean("noBlockingSpringKafkaTopic")
    public NewTopic createNoBlockingSpringKafkaTopic() {
        return TopicBuilder.name("spring-kafka-no-blocking-test").partitions(10).replicas(3).config(TopicConfig.COMPRESSION_TYPE_CONFIG,
                                                                                                    "zstd").build();
    }

    @Bean("blockingSpringKafkaTopic")
    public NewTopic createBlockingSpringKafkaTopic() {
        return TopicBuilder.name("spring-kafka-blocking-test").partitions(10).replicas(3).config(TopicConfig.COMPRESSION_TYPE_CONFIG,
                                                                                                 "zstd").build();
    }

}
