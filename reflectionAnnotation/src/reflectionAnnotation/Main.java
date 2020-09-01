package reflectionAnnotation;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product p = new Product("Design Patterns", "Todo dev deve saber!", BigDecimal.valueOf(59.90), "LIVRO");		
		
		Map<String, Object> props = MapGenerate.buildMap(p);
		
		props.forEach((k,v) -> 	System.out.println(k + " = " + v));	
		
	}

}
