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
public class TestMixedCasePasswordRule {
  
  @Autowired
  private MixedCasePasswordRule rule;
  
  @Test
  public void testNull() {
    boolean result = rule.testPassword(null);
    Assert.assertFalse(result);
  }
  
  @Test
  public void testBasicCorrect() {
    boolean result = rule.testPassword("abcd123");
    Assert.assertTrue(result);
  }
  
  @Test
  public void testNonLetter() {
    boolean result = rule.testPassword("a#cd123");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testNonLetter2() {
    boolean result = rule.testPassword("a'*&%cd123");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testCapital() {
    boolean result = rule.testPassword("aBcd123");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testWithSpace() {
    boolean result = rule.testPassword("abcd 123");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testAllLeters() {
    boolean result = rule.testPassword("abcd");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testNonAscii() {
    boolean result = rule.testPassword("最近の話題記事一覧");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testLongString() {
    boolean result = rule.testPassword(StringUtil.suggestRandom(1024 * 200, true));
    /* Make sure that large blocks don't break things. */
    Assert.assertTrue(result);
  }
}
