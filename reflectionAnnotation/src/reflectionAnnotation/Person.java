package reflectionAnnotation;

public class Person {

	@Parse(value ="description")
	private String firtName;
	@Parse(value="category")
	private String LastName;
	@Parse(value="name")
	private Integer age;
	
	public Person() {
		super();
	}
	
	public Person(String firtName, String lastName, Integer age) {
		super();
		this.firtName = firtName;
		LastName = lastName;
		this.age = age;
	}
	
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
