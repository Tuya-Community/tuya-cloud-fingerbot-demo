package com.tuya.cloud.Authentication;

import org.apache.pulsar.client.api.AuthenticationDataProvider;
import org.apache.pulsar.shade.org.apache.commons.codec.digest.DigestUtils;

public class FingerbotMqAuthenticationDataProvider implements AuthenticationDataProvider {

	private String commandData;

	public FingerbotMqAuthenticationDataProvider(String accessId, String accessKey) {
		this.commandData = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", accessId,
				DigestUtils.md5Hex(accessId + DigestUtils.md5Hex(accessKey)).substring(8, 24));
	}

	@Override
	public String getCommandData() {
		return commandData;
	}

	@Override
	public boolean hasDataForHttp() {
		return false;
	}

	@Override
	public boolean hasDataFromCommand() {
		return true;
	}

}
