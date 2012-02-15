package com.openthinks.woms.system.configuration;

import java.util.List;

import junit.framework.TestCase;

public class InputRememberXmlParserTest extends TestCase {

	private InputRememberConfigReader reader = InputRememberConfigReader
			.getInstance();

	public void setUp() {

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetStrategyMap() {
		List<InputRememberItem> items = reader.getInputRememberItems();

		for (InputRememberItem item : items) {
			System.out.println(item.getCategory() + "-" + item.getSize());

		}

		assertEquals(2, items.size());
	}

}
