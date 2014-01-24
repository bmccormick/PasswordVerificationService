package com.mccormi.service.password.rule;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mccormi.util.StringUtil;

public class LengthCheckPasswordRuleTest  extends TestCase {
	
	private static ApplicationContext context;
	private LengthCheckPasswordRule rule;

	@Before
	public void setUp() throws Exception {
		try{
			context = new ClassPathXmlApplicationContext("PasswordVerificationContext.xml");
		}catch(Exception e){
			System.err.println("Error opening context " + e);
			e.printStackTrace();
		}
		rule = (LengthCheckPasswordRule) context.getBean("lengthCheckPasswordRule");
	}

	@Test
	public void testNull() {
		boolean result = rule.testPassword(null);
		assertFalse(result);
	}
	
	@Test
	public void testLengthFour() {
		boolean result = rule.testPassword("abcd");
		assertFalse(result);
	}
	
	@Test
	public void testLengthFive() {
		boolean result = rule.testPassword("abcde");
		assertTrue(result);
	}
	
	@Test
	public void testLengthTwelve() {
		boolean result = rule.testPassword("abcdefghijkl");
		assertTrue(result);
	}
	
	@Test
	public void testLengthThirteen() {
		boolean result = rule.testPassword("abcdefghijklm");
		assertFalse(result);
	}
	
	@Test
	public void testLongString() {
		boolean result = rule.testPassword(StringUtil.suggestRandom(1024*200));
		assertFalse(result);
	}

}
