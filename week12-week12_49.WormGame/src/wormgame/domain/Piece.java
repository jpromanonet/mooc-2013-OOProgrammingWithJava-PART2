package wormgame.domain;

public class Piece {
	private int x;
	private int y;
	
	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	public boolean runsInto(Piece piece) {
		return (x == piece.x) && (y == piece.y);
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
