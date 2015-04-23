package game.element.edible;

import game.Model;
import game.element.Character;

public abstract class Effect extends Model {

	private int value;
	
	protected Effect() {
		super();
		
		setTitle("Effect");
		
		this.value = 0;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public abstract void act(Character character);
}
