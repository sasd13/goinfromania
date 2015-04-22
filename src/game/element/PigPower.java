package game.element;

public abstract class PigPower extends Power {

	public PigPower() {
		super();
		
		setTitle("PigPower");
	}
	
	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		setChanged();
		notifyObservers();
	}
}
