package com.mccormi.service.password;

import java.util.ArrayList;
import java.util.List;

import com.mccormi.service.password.rule.PasswordVerificationRule;

public class PasswordVerificationService {

  private List<PasswordVerificationRule> rules = new ArrayList<PasswordVerificationRule>();
  private List<PasswordVerificationRule> empty = new ArrayList<PasswordVerificationRule>();

  /**
   * Test whether a password is acceptable and passes the configured set of password
   * verification rules.
   *
   * @param password
   * @return boolean
   */
  public boolean testPassword(String password){
    if(null == password){
      return false;
    }

    for(PasswordVerificationRule rule: getRules()){
      if(!rule.testPassword(password)){
        return false;
      }
    }

    return true;
  }

  /**
   * Get the list of rules that have been configured for this verification service.
   *
   *
   * @return rules
   */
  public List<PasswordVerificationRule> getRules() {
    if(rules == null){
      /* If no rules are specified, return an empty list. */
      return empty;
    }
    return rules;
  }

  /**
   * Set the list of rules that should be used for verification by this service.
   *
   * The password being tested must pass all of the verification rules set here.
   *
   * @param rules
   */
  public void setRules(List<PasswordVerificationRule> rules) {
    this.rules = rules;
  }

}
