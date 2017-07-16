package util;

import java.util.HashMap;
import java.util.Map;

public class ValidationUtil {

private Map<String,String> regex = new HashMap<String, String>();

private void initializeRegex(){
	if(regex.size() == 0){
		regex.put("nome", "^(?=.{3,25}$)^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$");
		regex.put("cap", "^[0-9]{5}$");
		regex.put("telefono", "(^[0|3]{1}[0-9]{5,10}$)");
		regex.put("email", "^[a-zA-Z0-9_.-]+@[a-zA-Z_]+?.[a-zA-Z]{2,3}$");
		regex.put("usurname", "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$");
		regex.put("password", "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9$@$!%*?&]{8,30}");
	}
}

	
public boolean isEmpty(String aString){
	if (aString == null || aString == "" || aString.trim() == ""){
		return true;
	    
	}
		return false;
}

public boolean isAValidString(String aString,String aRegex){ 
	this.initializeRegex();
	if(!aString.matches(aRegex)){
		return false;
	}
	
	return true;
	}


public Map<String,String> getAllRegex(){
	this.initializeRegex();
	return regex;
	}
}