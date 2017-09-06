package com.mccormi.password.rule;

import com.google.common.base.Strings;

public class LengthCheckPasswordRule implements PasswordVerificationRule {
  
  //Default Lengths
  private int minLength = 0;
  private int maxLength = Integer.MAX_VALUE;
  
  @Override
  public boolean testPassword(String password) {
    if (Strings.isNullOrEmpty(password)) {
      return false;
    }
    
    int passwordLength = password.length();
    
    /* Check to make sure that the password isn't too small. */
    if (passwordLength < getMinLength()) {
      return false;
    }
    
    /* Check to make sure that the password isn't too large. */
    if (passwordLength > getMaxLength()) {
      return false;
    }
    
    /* It's just right. */
    return true;
  }
  
  public int getMinLength() {
    return minLength;
  }
  
  public void setMinLength(int minLength) {
    this.minLength = minLength;
  }
  
  public int getMaxLength() {
    return maxLength;
  }
  
  public void setMaxLength(int maxLength) {
    this.maxLength = maxLength;
  }
  
}
