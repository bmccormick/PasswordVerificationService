package com.mccormi.service.password;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mccormi.util.StringUtil;

public class PasswordVerificationServiceTest extends TestCase {

  private static ApplicationContext context;
  private PasswordVerificationService service;

  @Before
  public void setUp() throws Exception {
    try{
      context = new ClassPathXmlApplicationContext("PasswordVerificationContext.xml");
    }catch(Exception e){
      System.err.println("Error opening context " + e);
      e.printStackTrace();
    }
    service = (PasswordVerificationService) context.getBean("passwordVerificationService");
  }

  @Test
  public void testNull() {
    boolean result = service.testPassword(null);
    assertFalse(result);
  }

  @Test
  public void testBasicCorrect() {
    boolean result = service.testPassword("abcd123");
    assertTrue(result);
  }

  @Test
  public void testNonLetter() {
    boolean result = service.testPassword("a#cd123");
    assertFalse(result);
  }

  @Test
  public void testNonLetter2() {
    boolean result = service.testPassword("a'*&%cd123");
    assertFalse(result);
  }

  @Test
  public void testCapital() {
    boolean result = service.testPassword("aBcd123");
    assertFalse(result);
  }

  @Test
  public void testWithSpace() {
    boolean result = service.testPassword("abcd 123");
    assertFalse(result);
  }

  @Test
  public void testAllLeters() {
    boolean result = service.testPassword("abcd");
    assertFalse(result);
  }

  @Test
  public void testNonAscii() {
    boolean result = service.testPassword("最近の話題記事一覧");
    assertFalse(result);
  }

  @Test
  public void testLengthFour() {
    boolean result = service.testPassword("abc1");
    assertFalse(result);
  }

  @Test
  public void testLengthFive() {
    boolean result = service.testPassword("abcd1");
    assertTrue(result);
  }

  @Test
  public void testLengthTwelve() {
    boolean result = service.testPassword("abcdefghijk1");
    assertTrue(result);
  }

  @Test
  public void testLengthThirteen() {
    boolean result = service.testPassword("abcdefghijkl1");
    assertFalse(result);
  }

  @Test
  public void testLongString() {
    boolean result = service.testPassword(StringUtil.suggestRandom(1024*200, true));
    assertFalse(result);
  }

  @Test
  public void testDoubleRepeat() {
    boolean result = service.testPassword("abcdcd3");
    assertFalse(result);
  }

  @Test
  public void testLongRepeat() {
    boolean result = service.testPassword("1bcdefghijklmnop1bcdefghijklmnop");
    assertFalse(result);
  }

}
