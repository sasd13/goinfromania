package game.element.item;

import game.element.Element;
import game.element.draw.WallDrawing;

public class Wall extends Element {
	
	public static final String NAME = "Wall";
	
	public Wall() {
		super();
		
		setTitle(NAME);
		setDrawing(new WallDrawing());
	}
}
