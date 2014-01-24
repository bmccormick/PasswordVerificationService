/**
 * 
 */
package com.mccormi.service.password;

import com.mccormi.service.password.rule.LengthCheckPasswordRuleTest;
import com.mccormi.service.password.rule.MixedCasePasswordRuleTest;
import com.mccormi.service.password.rule.SequenceCheckPasswordRuleTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 *
 */
public class PasswordVerificationTestSuite extends TestCase {
	
	/**
	 * PasswordVerification Test Suite
	 * 
	 * 
	 * @return TestSuite
	 */
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.setName("Password Verification Test Suite");
		suite.addTestSuite(LengthCheckPasswordRuleTest.class);
		suite.addTestSuite(MixedCasePasswordRuleTest.class);
		suite.addTestSuite(SequenceCheckPasswordRuleTest.class);
		suite.addTestSuite(PasswordVerificationServiceTest.class);
		return suite;
	}

}
