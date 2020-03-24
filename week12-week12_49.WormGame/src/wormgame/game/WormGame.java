package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {
	
	private int width;
	private int height;
	private boolean continues;
	private Updatable updatable;
	private Worm worm;
	private Apple apple;
	
	public WormGame(int width, int height) {
		super(1000, null);
		Random random = new Random();
		this.width = width;
		this.height = height;
		this.continues = true;
		
		int wormX = width / 2;
		int wormY = height / 2;
		
		this.worm = new Worm(wormX, wormY, Direction.DOWN);
		
		int appleX = random.nextInt(width);
		int appleY = random.nextInt(height);
		
		while (appleX == wormX && appleY == wormY) {
			appleX = random.nextInt(width);
			appleY = random.nextInt(height);
		}
		
		this.apple = new Apple(appleX, appleY);
		addActionListener(this);
		setInitialDelay(2000);
		
	}
	
	private void createAndSetApple() {
		Random random = new Random();
		List<Piece> wormPieces = worm.getPieces();
		int appleX = random.nextInt(width);
		int appleY = random.nextInt(height);
		Apple newApple = new Apple(appleX, appleY);
		
		boolean insideWorm = worm.runsInto(newApple);
		
		while (insideWorm) {
			appleX = random.nextInt(width);
			appleY = random.nextInt(height);
			newApple = new Apple(appleX, appleY);
			insideWorm = worm.runsInto(newApple);
		}
		
		setApple(newApple);
	}
	
	public boolean continues() {
		return continues;
	}
	
	public void setUpdatable(Updatable updatable) {
		this.updatable = updatable;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Worm getWorm() {
		return worm;
	}
	
	public void setWorm(Worm worm) {
		this.worm = worm;
	}
	
	public Apple getApple() {
		return apple;
	}
	
	public void setApple(Apple apple) {
		this.apple = apple;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		worm.move();
		if (worm.runsInto(apple)) {
			worm.grow();
			createAndSetApple();
		}
		
		if (worm.runsIntoItself() || wormHitsBorder())
			continues = false;
		
		updatable.update();
		
		setDelay(1000 / worm.getLength());
		
		if (!continues) {
			return;
		}
		
	}
	
	private boolean wormHitsBorder() {
		Piece wormhead = worm.getHead();
		if (wormhead.getX() >= width || wormhead.getX() <= 0) {
			return true;
		}
		if (wormhead.getY() >= height || wormhead.getY() <= 0) {
			return true;
		}
		
		return false;
	}
}
