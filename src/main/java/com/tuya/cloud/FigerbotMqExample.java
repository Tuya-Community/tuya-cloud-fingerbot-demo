package com.tuya.cloud;

import com.alibaba.fastjson.JSON;
import com.tuya.cloud.configs.MqConfigs;
import com.tuya.cloud.configs.MqConsumer;
import com.tuya.cloud.domain.FigerbotMessage;
import com.tuya.cloud.utils.AESBase64Utils;

/**
 * @author jamesmsw
 * @date 2021/3/24 8:03 下午
 */
public class FigerbotMqExample {

    public static void main(String[] args) throws Exception {
        String url = MqConfigs.CN_SERVER_URL;
        String accessId = "xqp3hgufaf2dtkbet06a";
        String accessKey = "08e1eb6e7c004f0ea8341b6a6f6530de";

        MqConsumer mqConsumer = MqConsumer.build().serviceUrl(url).accessId(accessId).accessKey(accessKey)
                .maxRedeliverCount(3).messageListener(message -> {
                            System.out.println("---------------------------------------------------");
                            System.out.println("Message received:" + new String(message.getData()) + ",seq="
                                    + message.getSequenceId() + ",time=" + message.getPublishTime() + ",consumed time="
                                    + System.currentTimeMillis());
                            String jsonMessage = new String(message.getData());
                            FigerbotMessage vo = JSON.parseObject(jsonMessage, FigerbotMessage.class);
                            System.out.println("the real message data:" + AESBase64Utils.decrypt(vo.getData(), accessKey.substring(8, 24)));
                        }

                );
        mqConsumer.start();
    }
}
