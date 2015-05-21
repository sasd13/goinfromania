package anim.power;

import game.element.Direction;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Missile;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import controller.ArenaController;
import util.ArenaUtil;
import util.ImageLoader;

public class MissileNextAnimation extends PowerAnimation {

	public static final int DELAY_MOVE = 10;
	
	public MissileNextAnimation(Missile missile, Pig pig, Enemy enemy) {
		super(missile, pig, enemy);
		
		setDelay(DELAY_MOVE);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Missile missile = (Missile) getPower();
		Enemy enemy = (Enemy) getElementToAct();
		
		boolean canActInTouch = ArenaUtil.canActInTouch(missile, enemy);
		if (canActInTouch) {
			timer.stop();
			
			ArenaController.actionPigAttaksEnemy(enemy, missile);
		} else {
			Direction direction = ArenaUtil.pursue(missile, enemy);
			
			BufferedImage image;
			switch(direction) {
				case RIGHT :
					image = ImageLoader.loadFromPath("right_" + missile.getImageName());
					break;
				case UP :
					image = ImageLoader.loadFromPath("up_" + missile.getImageName());
					break;
				case DOWN :
					image = ImageLoader.loadFromPath("down_" + missile.getImageName());
					break;
				case LEFT : default :
					image = ImageLoader.loadFromPath("left_" + missile.getImageName());
					break;
			}
			missile.setImageWithDimension(image);
			
			ArenaController.actionMove(missile, direction);
		}

	}

}
