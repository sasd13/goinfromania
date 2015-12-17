package main.java.game.element.power;

public class Missile extends Power {

	public static final String NAME = "Missile";
	public static final String IMAGE_NAME = "missile.png";
	public static final int VALUE_DECREASE_CHARACTER_LIFE = 25;
	
	public Missile() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(2);
		setImageName(IMAGE_NAME);
		setPowerValue(VALUE_DECREASE_CHARACTER_LIFE);
	}
}
