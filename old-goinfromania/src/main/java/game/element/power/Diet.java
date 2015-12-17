package main.java.game.element.power;

public class Diet extends Power {
	
	public static final String NAME = "Diet";
	public static final int VALUE_DECREASE_PIG_ENERGY = 10;
	
	public Diet() {
		super();
		
		setName(NAME);
		setPowerValue(VALUE_DECREASE_PIG_ENERGY);
	}
}
