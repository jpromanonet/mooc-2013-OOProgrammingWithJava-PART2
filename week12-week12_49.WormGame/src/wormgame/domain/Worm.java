package wormgame.domain;

import wormgame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Worm {
	private int originalX;
	private int originalY;
	private Direction originalDirection;
	private List<Piece> worm;
	private boolean shouldGrow;
	public Worm(int originalX, int originalY, Direction originalDirection) {
		this.originalX = originalX;
		this.originalY = originalY;
		this.originalDirection = originalDirection;
		this.shouldGrow = true;
		worm = new ArrayList<Piece>();
		worm.add(new Piece(originalX, originalY));
	}
	
	public Direction getDirection() {
		return originalDirection;
	}
	
	public void setDirection(Direction dir) {
		originalDirection = dir;
	}
	
	public int getLength() {
		return worm.size();
	}
	
	public List<Piece> getPieces() {
		return worm;
	}
	
	public Piece getHead() {
		return worm.get(getLength() -1 );
	}
	
	public void move() {
		int newX = worm.get(worm.size()-1).getX();
		int newY = worm.get(worm.size()-1).getY();
		
		switch (originalDirection) {
			case UP: {
				newY -= 1;
				break;
			}
			
			case DOWN: {
				newY += 1;
				break;
			}
			
			case LEFT: {
				newX -= 1;
				break;
			}
			
			case RIGHT: {
				newX += 1;
				break;
			}
			
			default: {
				throw new RuntimeException();
			}
		}
		if (getLength() > 2 && !shouldGrow) {
			worm.remove(0);
		}
		
		if (shouldGrow) {
			shouldGrow = false;
		}
		
		worm.add(new Piece(newX, newY));
	}
	
	public void grow() {
		shouldGrow = true;
	}
	
	public boolean runsInto(Piece piece) {
		for (Piece wormPiece :
				worm) {
			boolean pieceLocationsMatch = wormPiece.getX() == piece.getX() && wormPiece.getY() == piece.getY();
			if(pieceLocationsMatch && !wormPiece.equals(piece))
				return true;
		}
		return false;
	}
	
	public boolean runsIntoItself() {
		Piece head = worm.get(getLength()-1);
		return runsInto(head);
	}
	
}
