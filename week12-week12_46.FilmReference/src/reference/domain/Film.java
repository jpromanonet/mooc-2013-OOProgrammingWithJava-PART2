package reference.domain;

public class Film {
	private String name;
	
	public Film(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Object object) {
		Film otherFilm;
		
		if (!(object instanceof Film))
			return false;
		
		otherFilm = (Film) object;
		
		return name.equals(otherFilm.name);
	}
	
	public int hashCode() {
		return name.hashCode();
	}
}
