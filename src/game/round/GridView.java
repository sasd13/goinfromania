package game.round;

import java.util.Observable;

import game.draw.Drawing;
import game.draw.IDrawable;

public class GridView extends PanelView implements IDrawable {

	public GridView() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Grid grid = (Grid) observable;
		
		draw(grid.getDrawing());
		
		super.update(observable, arg);
	}
	
	@Override
	public void draw(Drawing drawing) {
		// TODO Auto-generated method stub
		
	}
}
