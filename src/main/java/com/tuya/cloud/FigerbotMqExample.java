package com.tuya.cloud;

import com.alibaba.fastjson.JSON;
import com.tuya.cloud.Authentication.FigerbotMqAuthentication;
import com.tuya.cloud.domain.FigerbotMessage;
import com.tuya.cloud.utils.AESBase64Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author jamesmsw
 * @date 2021/3/24 8:03 下午
 */
@Slf4j
@Service
public class FigerbotMqExample {

    @Value("${mq.accessId}")
    private String accessId;
    @Value("${mq.accessKey}")
    private String accessKey;
    @Value("${mq.env}")
    private String env;
    @Value("${mq.serverUrl}")
    private String serverUrl;
    @Value("${mq.maxRedeliverCount}")
    private Integer maxRedeliverCount;
    @Value("${mq.debug}")
    private Boolean debug;


    @PostConstruct
    public void init() throws Exception {
        PulsarClient client = PulsarClient.builder().serviceUrl(serverUrl).allowTlsInsecureConnection(true)
                .authentication(new FigerbotMqAuthentication(accessId, accessKey)).build();
        Consumer consumer = client.newConsumer().topic(String.format("%s/out/%s", accessId, env))
                .subscriptionName(String.format("%s-sub", accessId)).subscriptionType(SubscriptionType.Failover)
                .deadLetterPolicy(DeadLetterPolicy.builder().maxRedeliverCount(maxRedeliverCount).build()).subscribe();
        do {
            try {
                Message message = consumer.receive();
                Long s = System.currentTimeMillis();
                onMessageArrived(message);
                if (debug) {
                    log.info("business processing cost={}", System.currentTimeMillis() - s);
                }
                consumer.acknowledge(message);
            } catch (PulsarClientException e) {
                log.error("error:", e);
            }
        } while (true);
    }

    public void onMessageArrived(Message message) throws Exception {
        System.out.println("---------------------------------------------------");
        System.out.println("Message received:" + new String(message.getData()) + ",seq="
                + message.getSequenceId() + ",time=" + message.getPublishTime() + ",consumed time="
                + System.currentTimeMillis());
        String jsonMessage = new String(message.getData());
        FigerbotMessage vo = JSON.parseObject(jsonMessage, FigerbotMessage.class);
        System.out.println("the real message data:" + AESBase64Utils.decrypt(vo.getData(), accessKey.substring(8, 24)));
    }

}
