package com.mccormi.password;

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
public class TestPasswordVerificationService {
  
  @Autowired
  private PasswordVerificationService service;
  
  @Test
  public void testNull() {
    boolean result = service.testPassword(null);
    Assert.assertFalse(result);
  }
  
  @Test
  public void testBasicCorrect() {
    boolean result = service.testPassword("abcd123");
    Assert.assertTrue(result);
  }
  
  @Test
  public void testNonLetter() {
    boolean result = service.testPassword("a#cd123");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testNonLetter2() {
    boolean result = service.testPassword("a'*&%cd123");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testCapital() {
    boolean result = service.testPassword("aBcd123");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testWithSpace() {
    boolean result = service.testPassword("abcd 123");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testAllLeters() {
    boolean result = service.testPassword("abcd");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testNonAscii() {
    boolean result = service.testPassword("最近の話題記事一覧");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testLengthFour() {
    boolean result = service.testPassword("abc1");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testLengthFive() {
    boolean result = service.testPassword("abcd1");
    Assert.assertTrue(result);
  }
  
  @Test
  public void testLengthTwelve() {
    boolean result = service.testPassword("abcdefghijk1");
    Assert.assertTrue(result);
  }
  
  @Test
  public void testLengthThirteen() {
    boolean result = service.testPassword("abcdefghijkl1");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testLongString() {
    boolean result = service.testPassword(StringUtil.suggestRandom(1024 * 200, true));
    Assert.assertFalse(result);
  }
  
  @Test
  public void testDoubleRepeat() {
    boolean result = service.testPassword("abcdcd3");
    Assert.assertFalse(result);
  }
  
  @Test
  public void testLongRepeat() {
    boolean result = service.testPassword("1bcdefghijklmnop1bcdefghijklmnop");
    Assert.assertFalse(result);
  }
  
}
