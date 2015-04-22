package game.element;

import game.draw.WallDrawing;

public class Wall extends Element {

	public Wall() {
		super();
		
		setTitle("Wall");
		
		setDrawing(new WallDrawing());
	}
}
