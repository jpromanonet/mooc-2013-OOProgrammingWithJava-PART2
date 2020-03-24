package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Vampires {
	
	public static void move(ArrayList<Vampire> vampires, Layout layout, Player player) {
		int nextX = 0;
		int nextY = 0;
		List<Vampire> vampiresToDie = new ArrayList<Vampire>();
		
		for (Vampire vampire :
				vampires) {
			
			nextX = moveX(vampire, layout);
			nextY = moveY(vampire, layout);
			
			HashMap<Integer, Integer> otherVamps = otherVampireCoordinates(vampires, vampire); // get coords of other vampires
			
			// if next position matches current position of another vampire, skip move
			if (otherVamps.keySet().contains(nextX) && otherVamps.values().contains(nextY)) {
				continue;
			}
			
			vampire.move(nextX, nextY);
			
			// if player and vampire run into each other, vampire dies
			if (vampire.getX() == player.getX() && vampire.getY() == player.getY()) {
				vampiresToDie.add(vampire);
			}
		}
		
		vampires.removeAll(vampiresToDie);
	}
	
	public static void movePlayerOnly(ArrayList<Vampire> vampires, Layout layout, Player player) {
		List<Vampire> vampiresToDie = new ArrayList<Vampire>();
		
		for (Vampire vampire :
				vampires) {
			if (vampire.getX() == player.getX() && vampire.getY() == player.getY()) {
				vampiresToDie.add(vampire);
			}
		}
		vampires.removeAll(vampiresToDie);
	}
	
	private static int moveX(Vampire vampire, Layout layout) {
		Random random = new Random();
		int nextX = vampire.getX() + random.nextInt(2) - 1;
		// vampires cannot leave the dungeon
		if (nextX < 0) {
			return 0;
		} else if (nextX > layout.getLength()) {
			return layout.getLength();
		} else {
			return nextX;
		}

//		return (nextX > layout.getLength() || nextX < 0) ? layout.getLength() : nextX;
	}
	
	private static int moveY(Vampire vampire, Layout layout) {
		Random random = new Random();
		int nextY = vampire.getY() + random.nextInt(2) - 1;
		// vampires cannot leave the dungeon
		if (nextY < 0) {
			return 0;
		} else if (nextY > layout.getheight()) {
			return layout.getLength();
		} else {
			return nextY;
		}
//		return nextY > layout.getheight() ? layout.getheight() : nextY;
	}
	
	public static HashMap<Integer, Integer> otherVampireCoordinates(ArrayList<Vampire> vampires, Vampire excludeVampire) {
		HashMap<Integer, Integer> vampCoords = new HashMap<Integer, Integer>();
		for (Vampire vampire :
				vampires) {
			if (vampire == excludeVampire) {
				continue;
			}
			
			vampCoords.put(vampire.getX(), vampire.getY());
		}
		
		return vampCoords;
	}
	
	public static ArrayList<Vampire> initializeVampires(int number, Layout layout) {
		ArrayList<Vampire> vampireList = new ArrayList<Vampire>();
		Random random = new Random();
		
		for (int i = 0; i < number; i++) {
			int randX = 0;
			int randY = 0;
			// below loop ensures vampires dont spawn on top of the player (0,0) at the beginning
			while (randX == 0 && randY == 0) {
				randX = random.nextInt(layout.getLength());
				randY = random.nextInt(layout.getheight());
			}
			
			vampireList.add(new Vampire(randX, randY));
		}
		
		return vampireList;
	}
}
