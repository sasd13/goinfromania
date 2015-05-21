package anim.power;

import game.element.Element;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Disease;

import java.awt.event.ActionEvent;

public class DiseaseAnimation extends PowerAnimation {
	
	public DiseaseAnimation(Disease disease, Enemy enemy, Pig pig) {
		super(disease, enemy, pig);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		Pig pig = (Pig) getElementToAct();
		
		if (count == 0) {
			pig.setLife(pig.getLife() - getPower().getPowerValue());
			pig.setSpeed(Element.SPEED_LOW);
		} else {
			pig.setSpeed(Element.SPEED_MEDIUM);
			timer.stop();
		}
	}
}
