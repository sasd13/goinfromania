package game.element.power;

import game.element.character.Character;

public class Run extends Power {

	public static final String NAME = "Run";
	public static final String MESSAGE = "Run away!!!";
	
	private String message;
	
	public Run() {
		super();
		
		setName(NAME);
		
		this.message = MESSAGE;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void act(Character character) {
		super.act(character);
	}
}
