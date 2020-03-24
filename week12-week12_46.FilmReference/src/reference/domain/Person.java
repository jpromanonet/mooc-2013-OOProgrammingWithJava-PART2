package reference.domain;

public class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Object object) {
		Person otherPerson;
		
		if (!(object instanceof Person))
			return false;
		
		otherPerson = (Person) object;
		
		return name.equals(otherPerson.name);
	}
	
	public int hashCode() {
		return name.hashCode();
	}
}
