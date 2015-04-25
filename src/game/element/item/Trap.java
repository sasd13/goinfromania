package game.element.item;

import game.element.Element;
import game.element.draw.TrapDrawing;

public class Trap extends Element {

	public static final String NAME = "Trap";
	
	public Trap() {
		super();
		
		setTitle(NAME);
		setDrawing(new TrapDrawing());
	}
}
