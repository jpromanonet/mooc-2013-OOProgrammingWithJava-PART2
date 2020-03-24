package movingfigure;

import java.awt.*;
import java.util.ArrayList;

public class CompoundFigure extends Figure {
	private ArrayList<Figure> figures;
	
	public CompoundFigure() {
		super(0, 0);
		figures = new ArrayList<Figure>();
	}
	
	public void add(Figure fig) {
		figures.add(fig);
	}
	
	@Override
	public void draw(Graphics graphics) {
		for (Figure figure :
				figures) {
			figure.draw(graphics);
		}
	}
	
	public void move(int dx, int dy) {
		for (Figure figure :
				figures) {
			figure.move(dx, dy);
		}
	}
}
