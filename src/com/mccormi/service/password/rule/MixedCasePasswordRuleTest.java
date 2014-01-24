package com.mccormi.service.password.rule;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mccormi.util.StringUtil;

public class MixedCasePasswordRuleTest  extends TestCase {

	private static ApplicationContext context;
	private MixedCasePasswordRule rule;

	@Before
	public void setUp() throws Exception {
		try{
			context = new ClassPathXmlApplicationContext("PasswordVerificationContext.xml");
		}catch(Exception e){
			System.err.println("Error opening context " + e);
			e.printStackTrace();
		}
		rule = (MixedCasePasswordRule) context.getBean("mixedCasePasswordRule");
	}

	@Test
	public void testNull() {
		boolean result = rule.testPassword(null);
		assertFalse(result);
	}
	
	@Test
	public void testBasicCorrect() {
		boolean result = rule.testPassword("abcd123");
		assertTrue(result);
	}
	
	@Test
	public void testNonLetter() {
		boolean result = rule.testPassword("a#cd123");
		assertFalse(result);
	}
	
	@Test
	public void testNonLetter2() {
		boolean result = rule.testPassword("a'*&%cd123");
		assertFalse(result);
	}
	
	@Test
	public void testCapital() {
		boolean result = rule.testPassword("aBcd123");
		assertFalse(result);
	}
	
	@Test
	public void testWithSpace() {
		boolean result = rule.testPassword("abcd 123");
		assertFalse(result);
	}
	
	@Test
	public void testAllLeters() {
		boolean result = rule.testPassword("abcd");
		assertFalse(result);
	}
	
	@Test
	public void testNonAscii() {
		boolean result = rule.testPassword("最近の話題記事一覧");
		assertFalse(result);
	}

	@Test
	public void testLongString() {
		boolean result = rule.testPassword(StringUtil.suggestRandom(1024*200, true));
		/* Make sure that large blocks don't break things. */
		assertTrue(result);
	}
}
