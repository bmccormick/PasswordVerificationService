package com;

import com.mccormi.service.password.PasswordVerificationTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;


public class CoreTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Core Tests");
		
		suite.addTest(PasswordVerificationTestSuite.suite());
		
		return suite;
	}

}
