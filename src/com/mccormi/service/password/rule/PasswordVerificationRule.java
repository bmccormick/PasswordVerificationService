/**
 * 
 */
package com.mccormi.service.password.rule;

/**
 * Interface that should be implemented to add a rule for password verification. 
 *
 */
public interface PasswordVerificationRule {
	
	public boolean testPassword(String password);

}
