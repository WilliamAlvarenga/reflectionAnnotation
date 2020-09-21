package reflectionDP.implementation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import reflectionDP.annotation.Command;
import reflectionDP.annotation.Module;

public class CommandImplement {

	private List<EModules> modules = Arrays.asList(EModules.values());
	
	public void setCommand( String params) {
		
		if(!params.contains(" ")) {
			System.out.print("Parametros invalidos!!");
			return;
		}		
		
		String[] tempParam = params.split(" ");
		
		EModules module = findModuleByAnnotation(tempParam[0]);
				
		if(null == module) {
			System.out.print("\n Modulo nao encontrado!! \n");
			return;
		}
		
		invokeCommand(module.getClassName(), tempParam[1]);
		
	}

	public void setCommand( Map<String ,String> params) {
		
		if(params.containsKey("command") && params.containsKey("module")) {
			
			EModules module = findModuleByAnnotation(params.get("module"));
			
			if(null == module) {
				System.out.print("\n Modulo nao encontrado!! \n" );
				return;
			}
			
			invokeCommand(module.getClassName(), params.get("command"));
			return;
		}
		
		System.out.print("Parametros invalidos!!");
	
		
	}

	private EModules findModuleByAnnotation(String module) {

		Field[] field = EModules.class.getFields();

		for (Field f : field) {
			if (f.isAnnotationPresent(Module.class)) {

				if (f.getAnnotation(Module.class).value().equalsIgnoreCase(module)) {

					return EModules.valueOf(f.getName());
				}

			} else {
				Optional<EModules> tempMod = findModuleByEmoduleValue(module);				
				if (tempMod.isPresent()) {
					return tempMod.get();
				}
			}
		}

		return null;

	}


	private Optional<EModules> findModuleByEmoduleValue(String module) {
		
		return modules.stream().filter(mod -> mod.toString().equalsIgnoreCase(module)).findAny();
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
