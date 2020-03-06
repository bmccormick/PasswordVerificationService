package com.mccormi.password.rule;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

public class MixedCasePasswordRule implements PasswordVerificationRule {
  
  @Override
  public boolean testPassword(String password) {
    if (Strings.isNullOrEmpty(password)) {
      return false;
    }
    
    /* Test to make sure that the password is made up of ascii characters to start off with */
    if (!CharMatcher.ascii().matchesAllOf(password)) {
      return false;
    }
    
    /* Test to make sure that the password is made up of letters or numbers */
    if (!CharMatcher.javaLetterOrDigit().matchesAllOf(password)) {
      return false;
    }
    
    /* Test to make sure that the letters are lower case. */
    if (!CharMatcher.digit().or(CharMatcher.javaLowerCase()).matchesAllOf(password)) {
      return false;
    }
    
    /* If we don't have at least one digit and letter then fail */
    if (!(CharMatcher.digit().matchesAnyOf(password) && CharMatcher.javaLetter().matchesAnyOf(password))) {
      return false;
    }
    
    /* We've passed the requirements for this Rule. */
    return true;
  }
  
}
