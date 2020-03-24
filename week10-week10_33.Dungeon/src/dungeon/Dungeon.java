package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {
	private boolean vampiresMove;
	private Layout layout;
	private Player player;
	private ArrayList<Vampire> vampires;
	private Scanner reader;
	
	public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
		layout = new Layout(length, height);
		player = new Player(moves, layout);
		reader = new Scanner(System.in);
		this.vampires = Vampires.initializeVampires(vampires, layout);
		this.vampiresMove = vampiresMove;
	}
	
	public void run() {
		while (true) {
			
			layout.updateBoard(player, vampires);
			printGameState();
			
			String command = reader.nextLine();
			movePieces(command);
			player.decrementMoves();
			
			if (vampires.isEmpty()) {
				System.out.println("YOU WIN");
				break;
			} else if (player.getMoves() <= 0) {
				System.out.println("YOU LOSE");
				break;
			}
		}
	}
	
	private void movePieces(String command) {
		for (int i = 0; i < command.length(); i++) {
			if (vampiresMove) {
				Vampires.move(vampires, layout, player);
			} else {
				Vampires.movePlayerOnly(vampires, layout, player);
			}
			
			player.move(command.charAt(i));
		}
	}
	
	public void printBoard() {
		for (int i = 0; i < layout.getBoard().size(); i++) {
			System.out.println(layout.getBoard().get(i));
		}
	}
	
	private void printVampires() {
		for (Vampire vampire :
				vampires) {
			System.out.println(vampire);
		}
	}
	
	public void printGameState() {
		System.out.println(player.getMoves() + "\n");
		System.out.println(player);
		printVampires();
		System.out.println("");
		printBoard();
	}
}
