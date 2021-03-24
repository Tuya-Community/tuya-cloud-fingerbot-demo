package com.tuya.cloud.Authentication;

import org.apache.pulsar.client.api.Authentication;
import org.apache.pulsar.client.api.PulsarClientException;

import java.io.IOException;
import java.util.Map;

/**
 * @author jamesmsw
 * @date 2021/3/24 7:50 下午
 */
public class FigerbotMqAuthentication implements Authentication {

    private String accessId;

    private String accessKey;

    public FigerbotMqAuthentication(String accessId, String accessKey) {
        this.accessId = accessId;
        this.accessKey = accessKey;
    }

    @Override
    public String getAuthMethodName() {
        return "auth1";
    }

    @Override
    public org.apache.pulsar.client.api.AuthenticationDataProvider getAuthData() {
        return new FingerbotMqAuthenticationDataProvider(this.accessId, this.accessKey);
    }

    @Override
    public void configure(Map<String, String> map) {
    }

    @Override
    public void start() throws PulsarClientException {
    }

    @Override
    public void close() throws IOException {
    }
}
