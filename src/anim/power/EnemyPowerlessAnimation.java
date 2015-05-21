package anim.power;

import game.element.character.Enemy;

import java.awt.event.ActionEvent;

import anim.Animation;

public class EnemyPowerlessAnimation extends Animation {

	private static final int DELAY_BEFORE_ENEMY_ATTAK_AGAIN = 2000;
	
	private Enemy enemy;
	
	public EnemyPowerlessAnimation(Enemy enemy) {
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
			timer.stop();
			
			this.enemy.setPowerful(true);
		}
	}
}
