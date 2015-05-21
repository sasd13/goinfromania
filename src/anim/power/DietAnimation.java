package anim.power;

import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Diet;

import java.awt.event.ActionEvent;

public class DietAnimation extends PowerAnimation {

	public DietAnimation(Diet diet, Enemy enemy, Pig pig) {
		super(diet, enemy, pig);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		Pig pig = (Pig) getElementToAct();
		
		if (count == 0) {
			pig.setGreedy(false);
		} else if (count >= getDuration() / getDelay()) {
			pig.setGreedy(true);
			timer.stop();
		} else {
			pig.setEnergy(pig.getEnergy() - getPower().getPowerValue());
		}
	}
}
