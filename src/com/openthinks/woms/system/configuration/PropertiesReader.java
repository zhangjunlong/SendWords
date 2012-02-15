package com.openthinks.woms.system.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reader of property file
 * 
 * @author Zhang Junlong
 * 
 */
public class PropertiesReader {

	Properties properties;

	public PropertiesReader(String fileName) {
		super();
		// Initiate properties instance
		load(fileName);
	}

	/**
	 * test if the properties is loaded
	 * 
	 * @return
	 */
	public boolean isLoaded() {
		if (null == properties) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Load the file with name specified
	 * 
	 * @param fileName
	 * @return
	 */
	public void load(String fileName) {
		InputStream is = this.getClass().getResourceAsStream("/" + fileName);

		properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperties(String propertyName) {
		if (null != properties)
			return properties.getProperty(propertyName);
		else
			return null;
	}
}
