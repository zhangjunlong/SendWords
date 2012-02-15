package com.openthinks.woms.system.configuration;

/**
 * SMTP帐号类
 * 
 * @author Zhang Junlong
 * 
 */
public class SendingAccount {
	// 服务器地址
	private String host;
	// 服务器端口
	private String port;
	// 登录smtp的帐号
	private String username;
	// 登录smtp的密码
	private String password;
	// 服务器的超时时间
	private String timeout;
	// 安全连接
	private String secure;
	// 重用间隔时间
	private int reuseInterval;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getSecure() {
		return secure;
	}

	public void setSecure(String secure) {
		this.secure = secure;
	}

	public int getReuseInterval() {
		return reuseInterval;
	}

	public void setReuseInterval(int reuseInterval) {
		this.reuseInterval = reuseInterval;
	}

	/**
	 * 转换为JSON字符串
	 * 
	 * @return
	 */
	public String toJsonString() {
		StringBuffer sb = new StringBuffer();

		sb.append("{ ");

		sb.append("\"host\" : " + "\"" + host + "\"");
		sb.append(", \"username\" : " + "\"" + username + "\"");
		sb.append(", \"password\" : " + "\"" + password + "\"");

		// 可选参数
		if (null != port && !"".equals(port))
			sb.append(", \"port\" : " + "\"" + port + "\"");

		if (null != timeout && !"".equals(timeout))
			sb.append(", \"timeout\" : " + "\"" + timeout + "\"");

		if (null != secure && !"".equals(secure))
			sb.append(", \"secure\" : " + "\"" + secure + "\"");

		sb.append(" }");

		return sb.toString();
	}
}
