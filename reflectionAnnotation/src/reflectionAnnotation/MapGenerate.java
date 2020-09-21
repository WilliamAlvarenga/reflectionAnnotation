package reflectionAnnotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import reflectionAnnotation.annotation.Ignore;
import reflectionAnnotation.annotation.PropertyName;

public class MapGenerate {

	public static Map<String,Object> buildMap(Object o) {
			
		Class<?> clss = o.getClass();
		
		Map<String,Object> map = new HashMap<>();
		
		for(Method m: clss.getMethods()) {	
			try {				
				if (isGetter(m)) {
					String property = "";		
					
					if (m.isAnnotationPresent(PropertyName.class)) {

						 property = m.getAnnotation(PropertyName.class).value();						
						
					} else {

						 property = getterToProperty(m.getName());
					}
					Object value = m.invoke(o);
					map.put(property, value);
				}
				
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}		
			
		}
			
		
	return map;
		
	}
	
	
	
	private static boolean isGetter(Method m) {	
		
		return m.getName().startsWith("get") && 
			   m.getReturnType() != void.class &&
			   m.getParameterTypes().length == 0 &&
			   !m.isAnnotationPresent(Ignore.class);
	}
	/**
	 * Remove Get from method
	 * @param getterName
	 * @return field 
	 */
	private static String getterToProperty(String getterName) {
	
		
		StringBuffer response = new StringBuffer();
		response.append(getterName.substring(3, 4).toLowerCase());
		response.append(getterName.substring(4));
		return response.toString();
	}
	
	
}
