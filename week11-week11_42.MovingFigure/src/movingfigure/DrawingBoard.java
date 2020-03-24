package movingfigure;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {
	private Figure figure;
	
	public DrawingBoard(Figure figure) {
		this.figure = figure;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		figure.draw(g);
	}
}
