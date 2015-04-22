package game.element;

import game.draw.TrapDrawing;

public class Trap extends Element {

	public Trap() {
		super();
		
		setTitle("Trap");
		
		setDrawing(new TrapDrawing());
	}
}
