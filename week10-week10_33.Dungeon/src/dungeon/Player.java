package dungeon;

public class Player {
	private int x;
	private int y;
	private int moves;
	private Layout board;
	
	public Player(int moves, Layout board) {
		this.moves = moves;
		this.board = board;
	}
	
	public int getMoves() {
		return moves;
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	public void move(char command) {
		if (moves > 0) {
			execute(command);
		}
	}
	public void decrementMoves() {
		if (moves > 0) {
			moves--;
		}
	}
	private void execute(char command) {
		switch (command) {
			case 's': {
				moveS();
				break;
			}
			case 'w': {
				moveW();
				break;
			}
			case 'a': {
				moveA();
				break;
			}
			case 'd': {
				moveD();
				break;
			}
			default: {
				System.out.println("Bad combination");
			}
		}
	}
	
	private void moveA() {
		
		if ((x - 1) <= 0) {
			x = 0;
		} else {
			x--;
		}
	}
	
	private void moveD() {
		if (x + 1 >= board.getLength()) {
			x = board.getLength()-1;
		} else {
			x++;
		}
	}
	
	private void moveW() {
		if (y - 1 < 0) {
			y = 0;
		} else {
			y--;
		}
	}
	
	private void moveS() {
		if ((y + 1) >= board.getheight()) {
			y = board.getheight()-1;
		} else {
			y++;
		}
	}
	
	public String toString() {
		return "@ " + x + " " + y;
	}
}
