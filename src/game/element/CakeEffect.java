package game.element;


public class CakeEffect extends Effect {

	public static final int DEFAULT_INCREASE_VALUE = 20;
	
	private int valueModifierPigEnergy;
	
	public CakeEffect() {
		super();
		
		this.valueModifierPigEnergy = DEFAULT_INCREASE_VALUE;
	}
	
	public int getValueModifierPigEnergy() {
		return this.valueModifierPigEnergy;
	}
	
	public void setValueModifierPigEnergy(int valueModifierPigEnergy) {
		this.valueModifierPigEnergy = valueModifierPigEnergy;
		
		notifyObservers();
	}
	
	@Override
	public void act(Pig pig) {
		Energy energy = pig.getEnergy();
		energy.setValue(energy.getValue() + this.valueModifierPigEnergy);
	}
}
