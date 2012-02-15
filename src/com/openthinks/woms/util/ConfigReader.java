package com.openthinks.woms.util;

import org.apache.log4j.Logger;

import com.openthinks.woms.system.configuration.PropertiesReader;

/**
 * 配置文件读取工具类
 * 
 * @author Zhang Junlong
 * 
 */
public class ConfigReader {

	private static Logger logger = Logger.getLogger(ConfigReader.class);

	private static PropertiesReader propReader;

	static {
		// Initiation
		String propFileName = "resources.properties";

		propReader = new PropertiesReader(propFileName);

		if (!propReader.isLoaded()) {
			logger.warn("The property file named '" + propFileName
					+ "' is not loaded.");
		}
	}

	/**
	 * 获取全局资源配置文件属性值
	 * 
	 * @param name
	 * @return
	 */
	public static String getProperty(String name) {
		return propReader.getProperties(name);
	}
}
