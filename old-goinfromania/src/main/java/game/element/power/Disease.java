package main.java.game.element.power;

public class Disease extends Power {

	public static final String NAME = "Disease";
	public static final int VALUE_DECREASE_PIG_LIFE = 20;
	
	public Disease() {
		super();
		
		setName(NAME);
		setPowerValue(VALUE_DECREASE_PIG_LIFE);
	}
}
