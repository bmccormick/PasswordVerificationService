package com.mccormi.password.config;

import com.google.common.collect.Lists;
import com.mccormi.password.PasswordVerificationService;
import com.mccormi.password.rule.LengthCheckPasswordRule;
import com.mccormi.password.rule.MixedCasePasswordRule;
import com.mccormi.password.rule.PasswordVerificationRule;
import com.mccormi.password.rule.SequenceCheckPasswordRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class AppConfig {
  
  @Bean
  public PasswordVerificationService getPasswordVerificationService() {
    PasswordVerificationService result = new PasswordVerificationService();
    
    List<PasswordVerificationRule> rules = Lists.newArrayList();
    rules.add(getLengthCheckPasswordRule());
    rules.add(getMixedCasePasswordRule());
    rules.add(new SequenceCheckPasswordRule());
    result.setRules(rules);
    
    return result;
  }
  
  @Bean
  public LengthCheckPasswordRule getLengthCheckPasswordRule() {
    LengthCheckPasswordRule rule = new LengthCheckPasswordRule();
    rule.setMaxLength(12);
    rule.setMinLength(5);
    return rule;
  }
  
  @Bean
  public MixedCasePasswordRule getMixedCasePasswordRule() {
    MixedCasePasswordRule rule = new MixedCasePasswordRule();
    return rule;
  }
  
  @Bean
  public SequenceCheckPasswordRule getSequenceCheckPasswordRule() {
    SequenceCheckPasswordRule rule = new SequenceCheckPasswordRule();
    return rule;
  }
}
