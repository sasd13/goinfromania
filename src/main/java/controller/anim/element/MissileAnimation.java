package main.java.controller.anim.element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import main.java.controller.ArenaController;
import main.java.controller.PigController;
import main.java.controller.anim.AnimationHandler;
import main.java.game.element.Direction;
import main.java.game.element.character.Enemy;
import main.java.game.element.character.Pig;
import main.java.game.element.power.Missile;
import main.java.util.ArenaUtil;
import main.java.util.ImageLoader;

public class MissileAnimation extends PowerAnimation {

	public static final int DELAY_MOVE = 7;
	
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
