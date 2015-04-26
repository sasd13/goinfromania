package game.element;

import game.element.draw.TrapDrawing;

public class Trap extends Element {

	public static final String NAME = "Trap";
	
	public Trap() {
		super();
		
		setName(NAME);
		setDrawing(new TrapDrawing());
	}
}
