package reflectionDP;

import java.util.HashMap;
import java.util.Map;

import reflectionDP.implementation.CommandImplement;

public class Main {

	public static void main(String[] args) {
		
		CommandImplement implement = new CommandImplement();
		
		String paramsString = "singer talk";
		
		implement.setCommand(paramsString);
		
		
		String paramsStringError = "singerMod talk";
		
		implement.setCommand(paramsStringError);
		
		/*
		 * params = "singer"; implement.setCommand(params);
		 * 
		 * 
		 * params = "register help"; implement.setCommand(params);
		 */
		
		System.out.print("\n");
		
		Map<String, String> paramsMap = new HashMap<String,String>();
		
		paramsMap.put("module", "register");
		paramsMap.put("command", "printSomething");
		
		implement.setCommand(paramsMap);
		
		Map<String, String> paramsMapError = new HashMap<String,String>();
		
		paramsMapError.put("module", "registerMod");
		paramsMapError.put("command", "printSomething");
		
		implement.setCommand(paramsMapError);

	}

}
