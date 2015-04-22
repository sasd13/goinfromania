package game.element;

public class SoporificPigPower extends PigPower {

	public SoporificPigPower() {
		super();
	}
	
	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		super.act(character);
	}
}
