package application.utils;

import java.util.regex.Pattern;

/**   
 
* @author Yz5z2  
 
*/

public class CheckValidTool {
	/**
	 *  
	 *  
	 *  @param userName 
	 *  @return boolean
	 */
	public  static boolean isValidUserName(String userName) {
		String patternName = "^[a-zA-Z]\\w{5,19}$";
		boolean matchName = Pattern.matches(patternName, userName);
		if(matchName) {
			return true;
		}
		return false;
	}
	
	/**
	 *	
	 *
	 *	@param password 
	 *	@return boolean
	 */
	public static boolean isValidPassword(String password) {
		String patternPasswd = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{8,30}$";		//密码包含字母、数字和特殊字符
		boolean matchPasswd = Pattern.matches(patternPasswd, password);
		if(matchPasswd) {
			return true;
		}
		return false;
	}

	
	
	
}
