package dungeon;

import java.util.ArrayList;

public class Layout {
	private int length;
	private int height;
	private static final String VAMPIRE = "v";
	private static final String PLAYER = "@";
	private ArrayList<StringBuilder> board;
//	private Player player;
//	private ArrayList<Vampire> vampires;
	
	public Layout(int length, int height) {
		this.length = length;
		this.height = height;
//		this.player = player;
//		this.vampires = vampires;
		board = new ArrayList<StringBuilder>();
		clearBoard();
	}
	
	public ArrayList<StringBuilder> getBoard() {
		return board;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getheight() {
		return height;
	}
	
	private void clearBoard() {
		board.clear();
		for (int i = 0; i < height; i++) {
			StringBuilder line = new StringBuilder();
			
			for (int j = 0; j < length; j++) {
				line.append(".");
			}
			board.add(line);
		}
	}
	
	public void updateBoard(Player player, ArrayList<Vampire> vampires) {
		clearBoard();
		updateVampiresOnBoard(vampires);
		updatePlayerOnBoard(player);
	}
	
	private void updatePlayerOnBoard(Player player) {
		int playerY = getPlayerY(player);
		int playerX = getPlayerX(player);
		
		board
				.get(playerY)
				.deleteCharAt(playerX)
				.insert(playerX, PLAYER);
	}
	
	private int getPlayerY(Player player) {
		int row = 0;
		if (player.getY() >= board.size())
			row = board.size()-1;
		else
			row = player.getY();
		
		return row;
	}
	
	private int getPlayerX(Player player) {
		int column = 0;
		if (player.getX() == length)
			column = length-1;
		else
			column = player.getX();
		
		return column;
	}
	
	private void updateVampiresOnBoard(ArrayList<Vampire> vampires) {
		for (Vampire vampire :
				vampires) {
			if (vampire.getX() == length) {
				board
						.get(vampire.getY())
						.deleteCharAt(length)
						.append(VAMPIRE);
			} else if (vampire.getX() == 0) {
				board
						.get(vampire.getY())
						.deleteCharAt(0)
						.insert(0, VAMPIRE);
			} else {
				board
						.get(vampire.getY())
						.deleteCharAt(vampire.getX())
						.insert(vampire.getX(), VAMPIRE);
			}
			
		}
	}
	
	
}
