package reflectionDP;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CommandImplement {

	private List<EModules> modules = Arrays.asList(EModules.values());
	
	public void setCommand( String params) {
		
		if(!params.contains(" ")) {
			System.out.print("Parametros invalidos!!");
			return;
		}		
		
		String[] tempParam = params.split(" ");
		
		Optional<EModules> module = findModule(tempParam[0]);
				
		if(!module.isPresent()) {
			System.out.print("\n Modulo nao encontrado!!");
			return;
		}
		
		invokeCommand(module.get().getClassName(), tempParam[1]);
		
	}

	public void setCommand( Map<String ,String> params) {
		
		if(params.containsKey("command") && params.containsKey("module")) {
			
			Optional<EModules> module = findModule(params.get("module"));
			
			if(!module.isPresent()) {
				System.out.print("\n Modulo nao encontrado!!" );
				return;
			}
			
			invokeCommand(module.get().getClassName(), params.get("command"));
			return;
		}
		
		System.out.print("Parametros invalidos!!");
	
		
	}

	private Optional<EModules> findModule(String tempParam) {	
		
		return modules.stream()
					  .filter(module-> module.toString().equalsIgnoreCase(tempParam))
					  .findAny();
					  
	}
	
	private void invokeCommand(String module, String command) {
		try {			
			
			Class<?> clazz = Class.forName(module);
			
			for(Method method : clazz.getDeclaredMethods()) {
				if(method.isAnnotationPresent(Command.class) && 
						method.getAnnotation(Command.class).value().equalsIgnoreCase(command)) {
					
					Object obj = clazz.newInstance();
					
					method.invoke(obj);
					
				}
			}
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
