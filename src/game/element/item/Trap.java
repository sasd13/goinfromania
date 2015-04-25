package game.element.item;

import game.draw.TrapDrawing;
import game.element.Element;

public class Trap extends Element {

	public static final String NAME = "Trap";
	
	public Trap() {
		super();
		
		setTitle(NAME);
		setDrawing(new TrapDrawing());
	}
}
