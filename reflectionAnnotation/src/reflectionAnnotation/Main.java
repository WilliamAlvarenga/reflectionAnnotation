package reflectionAnnotation;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product p = new Product("Design Patterns", "Todo dev deve saber!", BigDecimal.valueOf(59.90), "LIVRO");		
		
		Map<String, Object> props = MapGenerate.buildMap(p);
		for (String prop : props.keySet()) {
			System.out.println(prop + " = " + props.get(prop));
		}
		
		
	}

}