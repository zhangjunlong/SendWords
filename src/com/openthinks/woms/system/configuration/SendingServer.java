package com.openthinks.woms.system.configuration;

/**
 * 邮件发送服务器类，映射配置项中的服务器配置
 * 
 * @author Zhang Junlong
 * 
 */
public class SendingServer {

	private String host;

	private String url;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
