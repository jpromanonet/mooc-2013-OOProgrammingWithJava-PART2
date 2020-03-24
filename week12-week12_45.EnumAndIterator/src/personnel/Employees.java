package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
	private ArrayList<Person> personnel;
	
	public Employees() {
		personnel = new ArrayList<Person>();
	}
	
	public void add(Person person) {
		personnel.add(person);
	}
	
	public void add(List<Person> persons) {
		personnel.addAll(persons);
	}
	
	public void print() {
		Iterator<Person> iterator = personnel.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public void print(Education education) {
		Iterator<Person> iterator = personnel.iterator();
		
		while (iterator.hasNext()) {
			Person nextPerson = iterator.next();
			if (nextPerson.getEducation().equals(education))
				System.out.println(nextPerson);
		}
	}
	
	public void fire(Education education) {
		Iterator<Person> iterator = personnel.iterator();
		
		while (iterator.hasNext()) {
			Person nextPerson = iterator.next();
			if (nextPerson.getEducation() == education)
				iterator.remove();
		}
	}
}
