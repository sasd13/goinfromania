package game.element;

public class MissilePigPower extends PigPower {

	public static final int DEFAULT_DECREASE_VALUE = 50;
	
	private int valueDecreaseNutritionistLife;
	
	public MissilePigPower() {
		super();
		
		setTitle("Missile PigPower");
		
		this.valueDecreaseNutritionistLife = DEFAULT_DECREASE_VALUE;
	}
	
	public int getValueDecreaseNutritionistLife() {
		return this.valueDecreaseNutritionistLife;
	}
	
	public void setValueDecreaseNutritionistLife(
			int valueDecreaseNutritionistLife) {
		this.valueDecreaseNutritionistLife = valueDecreaseNutritionistLife;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		Life life = nutritionist.getLife();
		
		life.setValue(life.getValue() - this.valueDecreaseNutritionistLife);
		
		super.act(character);
	}
}
