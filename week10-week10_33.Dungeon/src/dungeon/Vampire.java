package dungeon;

public class Vampire {
	private int x;
	private int y;
	
	public Vampire(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "v " + x + " " + y;
	}
	
	public boolean equals(Object object) {
		if(!(object instanceof Vampire)) {
			return false;
		}
		Vampire otherVampire = (Vampire) object;
		if(x == otherVampire.x && y == otherVampire.y) {
			return true;
		}
		
		return false;
	}
}
