package anim.power;

import game.element.Direction;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Missile;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import util.ArenaUtil;
import util.ImageLoader;
import controller.ArenaController;
import controller.PigController;

public class MissileAnimation extends PowerAnimation {

	public static final int DELAY_MOVE = 10;
	
	public MissileAnimation(Missile missile, Pig pig, Enemy enemy) {
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
			
			PigController.actionPigAttaksEnemy(missile, (Pig) getElementActor(), enemy);
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
