package game.element.item;

import game.draw.WallDrawing;
import game.element.Element;

public class Wall extends Element {
	
	public static final String NAME = "Wall";
	
	public Wall() {
		super();
		
		setTitle(NAME);
		setDrawing(new WallDrawing());
	}
}
