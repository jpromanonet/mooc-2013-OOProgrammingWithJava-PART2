package wormgame.gui;

import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DrawingBoard extends JPanel implements Updatable {
	private WormGame game;
	private int pieceLength;
	
	public DrawingBoard(WormGame game, int pieceLength) {
		this.game = game;
		this.pieceLength = pieceLength;
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		List<Piece> wormPieces = game.getWorm().getPieces();
		Apple apple = game.getApple();
		graphics.setColor(Color.BLACK);
		for (Piece wormPiece :
				wormPieces) {
			graphics.fill3DRect(wormPiece.getX()*pieceLength, wormPiece.getY()*pieceLength, pieceLength, pieceLength, true);
		}
		graphics.setColor(Color.RED);
		graphics.fillOval(apple.getX()*pieceLength, apple.getY()*pieceLength, pieceLength, pieceLength);
		
	}
	
	@Override
	public void update() {
		super.repaint();
	}
}
