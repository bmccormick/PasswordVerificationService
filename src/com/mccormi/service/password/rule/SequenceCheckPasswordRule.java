/**
 * 
 */
package com.mccormi.service.password.rule;

/**
 * Must not contain any sequence of characters immediately followed by the same sequence.
 *
 */
public class SequenceCheckPasswordRule implements PasswordVerificationRule {

	@Override
	public boolean testPassword(String password) {
		if(null == password){
			return false;
		}
		int passwordLength = password.length();
		double half = Math.floor(passwordLength / 2);		
		
		for(int i = 1; i <= half; i++){
			for(int j = 0; j < passwordLength; j++){
				if(testPosition(j, i, password)){
					/* We've found a matching sequence. Therefore the test fails.*/
					return false;
				}
			}
		}
		
		/* No Matching sequences, this rule passes.*/
		return true;
	}
	
	/**
	 * With a given index and size, make sure that the characters following don't match. 
	 * This will return true if the following characters match the index/size initial substring.
	 * 
	 * @param index
	 * @param size
	 * @param String to test
	 * @return boolean
	 */
	private boolean testPosition(int index, int size, String password){
		if(null == password){
			return false;
		}
		
		int passwordLength = password.length();
		int startFirst = index;
		int endFirst = index + size;
		int startSecond = endFirst ;
		int endSecond = startSecond + size;
		
		if(endSecond > passwordLength){
			return false;
		}
		
		
		String first = password.substring(startFirst, endFirst);
		String second = password.substring(startSecond,endSecond);
		
		if(first.equals(second)){
			return true;
		}
		
		return false;
	}

}
