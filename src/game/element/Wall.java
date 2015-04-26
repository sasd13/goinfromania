package game.element;

import game.element.draw.WallDrawing;

public class Wall extends Element {
	
	public static final String NAME = "Wall";
	
	public Wall() {
		super();
		
		setName(NAME);
		setDrawing(new WallDrawing());
	}
}
