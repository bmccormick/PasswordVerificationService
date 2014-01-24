/**
 * 
 */
package com.mccormi.service.password.rule;

/**
 *  Must be between 5 and 12 characters in length.
 *
 */
public class LengthCheckPasswordRule implements PasswordVerificationRule {
	
	private int minLength = 0;
	private int maxLength = Integer.MAX_VALUE;

	@Override
	public boolean testPassword(String password) {
		
		if(null == password){
			return false;
		}
		
		int passwordLength = password.length();
		
		/* Check to make sure that the password isn't too small. */
		if(passwordLength < getMinLength()){
			return false;
		}
		
		/* Check to make sure that the password isn't too large. */
		if(passwordLength > getMaxLength()){
			return false;
		}		
		
		/* It's just right. */
		return true;
	}

	/**
	 * @return the minLength
	 */
	public int getMinLength() {
		return minLength;
	}

	/**
	 * @param minLength the minLength to set
	 */
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	/**
	 * @return the maxLength
	 */
	public int getMaxLength() {
		return maxLength;
	}

	/**
	 * @param maxLength the maxLength to set
	 */
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

}
