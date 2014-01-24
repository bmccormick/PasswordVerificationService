package com.mccormi.service.password.rule;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SequenceCheckPasswordRuleTest  extends TestCase {

	private static ApplicationContext context;
	private SequenceCheckPasswordRule rule;

	@Before
	public void setUp() throws Exception {
		try{
			context = new ClassPathXmlApplicationContext("PasswordVerificationContext.xml");
		}catch(Exception e){
			System.err.println("Error opening context " + e);
			e.printStackTrace();
		}
		rule = (SequenceCheckPasswordRule) context.getBean("sequenceCheckPasswordRule");
	}

	@Test
	public void testNull() {
		boolean result = rule.testPassword(null);
		assertFalse(result);
	}
	
	@Test
	public void testSimplestCorrect() {
		boolean result = rule.testPassword("a");
		assertTrue(result);
	}
	
	@Test
	public void testBasicCorrect() {
		boolean result = rule.testPassword("abcd123");
		assertTrue(result);
	}
	
	@Test
	public void testSingleRepeat() {
		boolean result = rule.testPassword("abcd1223");
		assertFalse(result);
	}
	
	@Test
	public void testDoubleRepeat() {
		boolean result = rule.testPassword("abcdcd3");
		assertFalse(result);
	}	
	
	@Test
	public void testLongRepeat() {
		boolean result = rule.testPassword("abcdefghijklmnopabcdefghijklmnop");
		assertFalse(result);
	}
	
	@Test
	public void testNonAscii() {
		boolean result = rule.testPassword("最近の話題記事一覧");
		assertTrue(result);
	}

}
