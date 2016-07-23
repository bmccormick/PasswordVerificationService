package com.mccormi.password.rule;

import com.mccormi.password.config.TestAppConfig;
import com.mccormi.password.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
@WebAppConfiguration
public class TestLengthCheckPasswordRule {
	
  @Autowired
	private LengthCheckPasswordRule rule;
  
  @Test
	public void testNull() {
		boolean result = rule.testPassword(null);
    Assert.assertFalse(result);
	}
	
	@Test
	public void testLengthFour() {
		boolean result = rule.testPassword("abcd");
    Assert.assertFalse(result);
	}
	
	@Test
	public void testLengthFive() {
		boolean result = rule.testPassword("abcde");
    Assert.assertTrue(result);
	}
	
	@Test
	public void testLengthTwelve() {
		boolean result = rule.testPassword("abcdefghijkl");
    Assert.assertTrue(result);
	}
	
	@Test
	public void testLengthThirteen() {
		boolean result = rule.testPassword("abcdefghijklm");
    Assert.assertFalse(result);
	}
	
	@Test
	public void testLongString() {
		boolean result = rule.testPassword(StringUtil.suggestRandom(1024*200));
    Assert.assertFalse(result);
	}

}
