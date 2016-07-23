package com.mccormi.password.rule;

import com.mccormi.password.config.TestAppConfig;
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
public class TestSequenceCheckPasswordRule {
  
  @Autowired
  private SequenceCheckPasswordRule rule;
  
  @Test
  public void testNull() {
    boolean result = rule.testPassword(null);
    Assert.assertFalse(result);
  }
  
  @Test
  public void testSimplestCorrect() {
    boolean result = rule.testPassword("a");
    Assert.assertTrue(result);
  }
  
  @Test
  public void testBasicCorrect() {
    boolean result = rule.testPassword("abcd123");
    Assert.assertTrue(result);
  }
  
  @Test
  public void testSingleRepeat() {
    boolean result = rule.testPassword("abcd1223");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testDoubleRepeat() {
    boolean result = rule.testPassword("abcdcd3");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testLongRepeat() {
    boolean result = rule.testPassword("abcdefghijklmnopabcdefghijklmnop");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testNonAscii() {
    boolean result = rule.testPassword("最近の話題記事一覧");
    Assert.assertTrue(result);
  }
  
}
