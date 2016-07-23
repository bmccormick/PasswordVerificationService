package com.mccormi.password.rule;

public interface PasswordVerificationRule {
  
  boolean testPassword(String password);
  
}
