package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {
	public PersonalBoard(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void initiateRandomCells(double v) {
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (cellShouldLive(generateRandomDouble(), v)) {
					turnToLiving(x, y);
				} else {
					turnToDead(x, y);
				}
			}
		}
	}
	
	private double generateRandomDouble() {
		return new Random().nextDouble();
	}
	
	private boolean cellShouldLive(double generated, double threshold) {
		if (generated <= threshold) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isAlive(int x, int y) {
		if (withinBoard(x, y)) {
			return getBoard()[x][y];
		}
		return false;
	}
	
	@Override
	public void turnToLiving(int x, int y) {
		if (withinBoard(x, y)) {
			getBoard()[x][y] = true;
		}
	}
	
	@Override
	public void turnToDead(int x, int y) {
		if (withinBoard(x, y)) {
			getBoard()[x][y] = false;
		}
	}
	
	@Override
	public int getNumberOfLivingNeighbours(int x, int y) {
		return calculateLivingNeighbours(x, y);
	}
	
	private int maxRightPosition() {
		return getWidth()-1;
	}
	
	private int maxBottomPosition() {
		return getHeight()-1;
	}
	
	private int calculateLivingNeighbours(int x, int y) {
		int result;
		if (x == 0 && y == 0) {
			result = locationTopLeftCorner(x, y);
		} else if (x == maxRightPosition() && y == 0) {
			result = locationTopRightCorner(x, y);
		} else if (x == 0 && y == maxBottomPosition()) {
			result = locationBottomLeftCorner(x, y);
		} else if (x == maxRightPosition() && y == maxBottomPosition()) {
			result = locationBottomRightCorner(x, y);
		} else if (x == 0 && y != maxBottomPosition() && y != 0) {
			result = locationLeftColumn(x, y);
		} else if (x == maxRightPosition() && y != maxBottomPosition() && y != 0) {
			result = locationRightColumn(x, y);
		} else if (x != 0 && x != maxRightPosition() && y == 0) {
			result = locationTopRow(x, y);
		} else if (x != 0 && x != maxRightPosition() && y == maxBottomPosition()) {
			result = locationBottomRow(x, y);
		} else {
			result = locationMiddle(x, y);
		}
		return result;
	}
	
	/**
	 * Returns 3 sets of coordinates for the neighbouring cells. Uses a quadrant system to determine which coordinates to send.
	 * Quadrant start is determined by the first parameter - quadrants go clockwise and start at 3, 6, 9, 12 o'clock.
	 *
	 * @param clockWiseStart
	 * @param x
	 * @param y
	 * @return
	 */
	private int[][] getNeighbourCoordinates(int clockWiseStart, int x, int y) {
		int[][] cornerLocations;
		
		switch (clockWiseStart) {
			case 3: {
				cornerLocations = new int[][]{{x + 1, y}, {x + 1, y + 1}, {x, y + 1}};
				break;
			}
			
			case 6: {
				cornerLocations = new int[][]{{x, y + 1}, {x - 1, y + 1}, {x - 1, y}};
				break;
			}
			
			case 9: {
				cornerLocations = new int[][]{{x - 1, y}, {x - 1, y - 1}, {x, y - 1}};
				break;
			}
			
			case 12: {
				cornerLocations = new int[][]{{x, y - 1}, {x + 1, y - 1}, {x + 1, y}};
				break;
			}
			
			default: {
				cornerLocations = new int[][]{{}, {}, {}};
				throw new IllegalArgumentException();
			}
		}
		
		return cornerLocations;
	}
	
	private int locationTopRightCorner(int x, int y) {
		int[][] coords = getNeighbourCoordinates(6, x, y);
		return loopAndCount(coords, false);
	}
	
	private int locationTopLeftCorner(int x, int y) {
		int[][] coords = getNeighbourCoordinates(3, x, y);
		return loopAndCount(coords, false);
	}
	
	private int locationBottomLeftCorner(int x, int y) {
		int[][] coords = getNeighbourCoordinates(12, x, y);
		return loopAndCount(coords, false);
	}
	
	private int locationBottomRightCorner(int x, int y) {
		int[][] coords = getNeighbourCoordinates(9, x, y);
		return loopAndCount(coords, false);
	}
	
	private int locationRightColumn(int x, int y) {
		int[][] coords1 = getNeighbourCoordinates(6, x, y);
		int[][] coords2 = getNeighbourCoordinates(9, x, y);
		
		int alive = loopAndCount(coords1, false) + loopAndCount(coords2, true);
		return alive;
	}
	
	private int locationLeftColumn(int x, int y) {
		int[][] coords1 = getNeighbourCoordinates(12, x, y);
		int[][] coords2 = getNeighbourCoordinates(3, x, y);
		int alive = loopAndCount(coords1, false) + loopAndCount(coords2, true);
		return alive;
	}
	
	private int locationTopRow(int x, int y) {
		int[][] coords1 = getNeighbourCoordinates(3, x, y);
		int[][] coords2 = getNeighbourCoordinates(6, x, y);
		
		int alive = loopAndCount(coords1, false) + loopAndCount(coords2, true);
		return alive;
	}
	
	private int locationBottomRow(int x, int y) {
		int[][] coords1 = getNeighbourCoordinates(9, x, y);
		int[][] coords2 = getNeighbourCoordinates(12, x, y);
		
		int alive = loopAndCount(coords1, false) + loopAndCount(coords2, true);
		return alive;
	}
	
	private int locationMiddle(int x, int y) {
		int[][] coords1 = getNeighbourCoordinates(12, x, y);
		int[][] coords2 = getNeighbourCoordinates(3, x, y);
		int[][] coords3 = getNeighbourCoordinates(6, x, y);
		int[][] coords4 = getNeighbourCoordinates(9, x, y);
		int alive = loopAndCount(coords1, true) + loopAndCount(coords2, true) + loopAndCount(coords3, true) + loopAndCount(coords4, true);
		return alive;
	}
	
	private int loopAndCount(int[][] coords, boolean skipFirst) {
		int alive = 0;
		
		for (int i = 0; i < coords.length; i++) {
			int x = coords[i][0];
			int y = coords[i][1];
			
			if (skipFirst && i == 0) {
				continue;
			}
			
			if (isAlive(x, y))
				alive++;
		}
		
		return alive;
	}
	
	@Override
	public void manageCell(int x, int y, int livingNeighbours) {
		if(livingNeighbours < 2) {
			turnToDead(x,y);
		} else if (livingNeighbours == 3) {
			turnToLiving(x,y);
		} else if (livingNeighbours > 3) {
			turnToDead(x, y);
		}
	}
	
	private boolean withinBoard(int x, int y) {
		if (x < getWidth() && y < getHeight() && x >= 0 && y >= 0) {
			return true;
		}
		return false;
	}
}
