package com.openthinks.woms.system.configuration;

import junit.framework.TestCase;

public class SendingAccountTest extends TestCase {

	public void testToJsonString() {
		SendingAccount account = new SendingAccount();

		account.setHost("dbank@qq.com");
		account.setUsername("dbank");
		account.setPassword("password");

		String expectJsonStr = "{ host : \"dbank@qq.com\", username : \"dbank\", password : \"password\" }";
		assertEquals(expectJsonStr, account.toJsonString());

		account.setPort("25");
		account.setSecure("ssl");
		account.setTimeout("100");
		expectJsonStr = "{ host : \"dbank@qq.com\", username : \"dbank\", password : \"password\", port : \"25\", timeout : \"100\", secure : \"ssl\" }";
		assertEquals(expectJsonStr, account.toJsonString());
	}

}
