package reflectionAnnotation;

import java.lang.reflect.Field;

public class SetterParse {

	public static Object setterObjt(Object to, Object by) {

		try {
			
		
		Class<?> toCls = to.getClass();
		Class<?> byCls = by.getClass();

		for (Field field : byCls.getDeclaredFields()) {

			if (field.isAnnotationPresent(Parse.class)) {
				try {
					Field fieldTmp = toCls.getDeclaredField(field.getAnnotation(Parse.class).value());

					field.setAccessible(true);
					fieldTmp.setAccessible(true);

					if (!field.getType().equals(fieldTmp.getType())) {					
						
						throw new Exception("Type of field different: " +field.getType()+ " to " + fieldTmp.getType() );
					}
					
					fieldTmp.set(to, field.get(by));

				} catch (Exception e) {
					System.out.print("Erro: " + e.getMessage());
				}

			}

		}

		return to;

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return null;
	}
	
	public static Object setterObjt( Object by) {
		
		try {

			Class<?> clazzBy = by.getClass();

			Class<?> clazzTo = clazzBy.getAnnotation(ParseClass.class).value();

			if (null == clazzTo) {
				throw new Exception("Class Not Found");
			}		

			return setterObjt(clazzTo.newInstance(), by );

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return null;
		
	}

}
