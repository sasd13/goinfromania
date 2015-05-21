package anim.power;

import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Paralyze;

import java.awt.event.ActionEvent;

public class ParalyzeAnimation extends PowerAnimation {

	public ParalyzeAnimation(Paralyze paralyze, Pig pig, Enemy enemy) {
		super(paralyze, pig, enemy);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		Enemy enemy = (Enemy) getElementToAct();
		
		if (count == 0) {
			enemy.setMovable(false);
			enemy.setPowerful(false);
		} else {
			enemy.setMovable(true);
			enemy.setPowerful(true);
			timer.stop();
		}
	}
}
