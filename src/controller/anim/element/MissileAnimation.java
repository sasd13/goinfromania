package controller.anim.element;

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
import controller.anim.AnimationHandler;

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
		if (!canActInTouch) {
			Direction direction = ArenaUtil.pursue(missile, enemy);
			
			BufferedImage image;
			switch(direction) {
				case NORTH:
					image = ImageLoader.loadFromPath("north_" + missile.getImageName());
					break;
				case SOUTH:
					image = ImageLoader.loadFromPath("south_" + missile.getImageName());
					break;
				case WEST:
					image = ImageLoader.loadFromPath("west_" + missile.getImageName());
					break;
				case EAST: default:
					image = ImageLoader.loadFromPath("east_" + missile.getImageName());
					break;
			}
			missile.setImageWithDimension(image);
			
			ArenaController.actionMove(missile, direction);
		} else {
			PigController.actionPigAttaksEnemy(missile, (Pig) getElementActor(), enemy);
			
			AnimationHandler.finish(this);
		}
	}
}
