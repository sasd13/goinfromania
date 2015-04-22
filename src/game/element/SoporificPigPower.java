package game.element;

public class SoporificPigPower extends PigPower {

	public SoporificPigPower() {
		super();
		
		setTitle("Soporific PigPower");
	}
	
	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		super.act(character);
	}
}
