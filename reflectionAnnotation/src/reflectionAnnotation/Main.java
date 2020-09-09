package reflectionAnnotation;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Product product = new Product("Design Patterns", "Todo dev deve saber!", BigDecimal.valueOf(59.90),
					"LIVRO");

			Person person = new Person("PrimerioNome", "UltimoNome", 50);

			Map<String, Object> props = MapGenerate.buildMap(product);

			props.forEach((k, v) -> System.out.println(k + " = " + v));

			product = (Product) SetterParse.setterObjt(person, product);

			System.out.print("########### \n");

			System.out.print(product.getCategory() + "\n");

			System.out.print("########### \n");

			Product newProd = (Product) SetterParse.setterObjt(person);

			System.out.print(newProd.getDescription());

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
