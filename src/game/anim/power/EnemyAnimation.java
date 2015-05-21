package game.anim.power;

import game.anim.Animation;
import game.element.character.Enemy;

import java.awt.event.ActionEvent;

public class EnemyAnimation extends Animation {

	private static final int DELAY_BEFORE_ENEMY_ATTAK_AGAIN = 2000;
	
	private Enemy enemy;
	
	public EnemyAnimation(Enemy enemy) {
		super();
		
		setDelay(DELAY_BEFORE_ENEMY_ATTAK_AGAIN);
		
		this.enemy = enemy;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {
			this.enemy.setPowerful(false);
		} else {
			this.enemy.setPowerful(true);
			timer.stop();
		}
	}
}
