package com.openthinks.woms.system.configuration;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX Parser of input-remember.xml
 * 
 * @author Zhang Junlong
 * 
 */
public class InputRememberXmlParser extends DefaultHandler {

	private static List<InputRememberItem> inputRememberItems = new ArrayList<InputRememberItem>();

	public static List<InputRememberItem> getInputRememberItems() {
		return inputRememberItems;
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {

		// try {
		// OutputStreamWriter outw = new OutputStreamWriter(System.out);
		// outw.write(ch, start, length);
		// outw.flush();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	public void setDocumentLocator(Locator locator) {
		// this.locator = locator;
	}

	public void startDocument() throws SAXException {
	}

	public void endDocument() throws SAXException {
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		// 解析策略配置
		if (qName.equals("item")) {
			InputRememberItem inputRememberItem = new InputRememberItem();
			for (int i = 0; i < atts.getLength(); i++) {
				String attName = atts.getQName(i);

				if (attName.equalsIgnoreCase("category"))
					inputRememberItem.setCategory(atts.getValue(i));

				if (attName.equalsIgnoreCase("size"))
					inputRememberItem.setSize(atts.getValue(i));

			}

			inputRememberItems.add(inputRememberItem);
		}

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

	}

}
