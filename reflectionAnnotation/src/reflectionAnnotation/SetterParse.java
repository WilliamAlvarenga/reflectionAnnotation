package reflectionAnnotation;

import java.lang.reflect.Field;

public class SetterParse {

	public static Object setterObjt(Object to, Object by) {

		Class<?> toCls = to.getClass();
		Class<?> byCls = by.getClass();

		for (Field field : byCls.getDeclaredFields()) {

			if (field.isAnnotationPresent(Parse.class)) {
				try {
					Field fieldTmp = toCls.getDeclaredField(field.getAnnotation(Parse.class).value());

					field.setAccessible(true);
					fieldTmp.setAccessible(true);

					if (field.getType().equals(fieldTmp.getType())) {

						fieldTmp.set(to, field.get(by));
					}

				} catch (Exception e) {
					System.out.print("Erro: " + e.getMessage());
				}

			}

		}

		return to;

	}

}
