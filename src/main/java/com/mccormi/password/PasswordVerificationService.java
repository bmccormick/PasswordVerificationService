package com.mccormi.password;

import com.google.common.collect.Lists;
import com.mccormi.password.rule.PasswordVerificationRule;
import java.util.List;

public class PasswordVerificationService {
  
  private List<PasswordVerificationRule> rules = Lists.newArrayList();
  
  public boolean testPassword(String password) {
    if (null == password) {
      return false;
    }
    
    for (PasswordVerificationRule rule : getRules()) {
      if (!rule.testPassword(password)) {
        return false;
      }
    }
    
    return true;
  }
  
  public List<PasswordVerificationRule> getRules() {
    return rules;
  }
  
  public void setRules(List<PasswordVerificationRule> rules) {
    this.rules = rules;
  }
  
}
