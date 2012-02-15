package com.openthinks;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * A abstract class for all test cases in system
 * 
 * Basic resources are loaded in the class
 * 
 * @author Zhang Junlong
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/conf/spring/applicationContext-*.xml",
		"/conf/spring/test/*.xml" })
public abstract class SpringTestSupport {

}
