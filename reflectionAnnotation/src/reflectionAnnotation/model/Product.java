package reflectionAnnotation.model;

import java.math.BigDecimal;

import reflectionAnnotation.annotation.Ignore;
import reflectionAnnotation.annotation.PropertyName;

public class Product {

	private String name;	
	private String description;	
	private BigDecimal price;
	private String category;
	
	public Product() {
		super();
	}
	
	public Product(String name, String description, BigDecimal price, String category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@PropertyName(value = "portrayal")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@PropertyName(value ="$")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Ignore
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
}
