package com.mccormi.password.rule;

import com.google.common.base.Strings;

public class SequenceCheckPasswordRule implements PasswordVerificationRule {
  
  @Override
  public boolean testPassword(String password) {
    if (Strings.isNullOrEmpty(password)) {
      return false;
    }
    int passwordLength = password.length();
    double half = Math.floor(passwordLength / 2);
    
    for (int i = 1; i <= half; i++) {
      for (int j = 0; j < passwordLength; j++) {
        if (testPosition(j, i, password)) {
          /* We've found a matching sequence. Therefore the test fails.*/
          return false;
        }
      }
    }
    
    /* No Matching sequences, this rule passes.*/
    return true;
  }
  
  private boolean testPosition(int index, int size, String password) {
    if (null == password) {
      return false;
    }
    
    int passwordLength = password.length();
    int startFirst = index;
    int endFirst = index + size;
    int startSecond = endFirst;
    int endSecond = startSecond + size;
    
    if (endSecond > passwordLength) {
      return false;
    }
    
    String first = password.substring(startFirst, endFirst);
    String second = password.substring(startSecond, endSecond);
    
    if (first.equals(second)) {
      return true;
    }
    
    return false;
  }
  
}
