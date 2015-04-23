package game.element.edible;

import game.element.Character;
import game.element.Life;
import game.element.Nutritionist;

public class MissileEffect extends Effect {

	public static final int VALUE_DECREASE_NUTRITIONIST_LIFE = 50;
	
	public MissileEffect() {
		super();
		
		setTitle("MissileEffect");
		
		setValue(VALUE_DECREASE_NUTRITIONIST_LIFE);
	}
	
	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		Life life = nutritionist.getLife();
		life.setValue(life.getValue() - getValue());
	}
}
