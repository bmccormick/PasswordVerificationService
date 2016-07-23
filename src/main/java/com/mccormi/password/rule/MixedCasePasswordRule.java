package com.mccormi.password.rule;

import com.google.common.base.CharMatcher;


public class MixedCasePasswordRule implements PasswordVerificationRule {
  
  @Override
  public boolean testPassword(String password) {
    if (null == password) {
      return false;
    }
    
		/* Test to make sure that the password is made up of ascii characters to start off with */
    if (!CharMatcher.ASCII.matchesAllOf(password)) {
      return false;
    }
    
		/* Test to make sure that the password is made up of letters or numbers */
    if (!CharMatcher.JAVA_LETTER_OR_DIGIT.matchesAllOf(password)) {
      return false;
    }
    
		/* Test to make sure that the letters are lower case. */
    if (!CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).matchesAllOf(password)) {
      return false;
    }
		
		/* If we don't have at least one digit and letter then fail */
    if (!(CharMatcher.DIGIT.matchesAnyOf(password) && CharMatcher.JAVA_LETTER.matchesAnyOf(password))) {
      return false;
    }
		
		/* We've passed the requirements for this Rule. */
    return true;
  }
  
}
