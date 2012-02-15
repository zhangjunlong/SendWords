package com.openthinks.woms.system.configuration;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class InputRememberConfigReader {
	private static InputRememberConfigReader inputRememberConfigReader = new InputRememberConfigReader();

	private List<InputRememberItem> inputRememberItems;

	private InputRememberConfigReader() {
		try {
			this.parse("input-remember.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static InputRememberConfigReader getInstance() {
		return inputRememberConfigReader;
	}

	public List<InputRememberItem> getInputRememberItems() {
		return inputRememberItems;
	}

	private void parse(String filename) throws Exception {

		// 将我们的解析器对象化
		InputRememberXmlParser handler = new InputRememberXmlParser();

		// 获取SAX工厂对象
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(false);
		factory.setValidating(false);

		// 获取SAX解析
		SAXParser parser = factory.newSAXParser();

		// 得到配置文件myenv.xml所在目录. tomcat中是在WEB-INF/classes
		// 下例中BeansConstants是用来存放xml文件中配置信息的类,可以自己代替或定义
		URL confURL = InputRememberConfigReader.class.getClassLoader()
				.getResource(filename);

		try {
			// 将解析器和解析对象myenv.xml联系起来,开始解析
			parser.parse(confURL.toString(), handler);
			// 获取解析成功后的属性 以后 我们其他应用程序只要调用本程序的props就可以提取出属性名称和值了
			inputRememberItems = InputRememberXmlParser.getInputRememberItems();
		} finally {
			factory = null;
			parser = null;
			handler = null;
		}

	}

}