package game.anim.power;

import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Paralyze;
import game.util.ImageLoader;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class ParalyzeAnimation extends PowerAnimation {

	/*
	 * Paralyse un ennemi pendant 8 secondes et l'mpeche l'ennemi d'attaquer
	 */
	public static final int DURATION_STOP_NUTRITIONIST_MOVE = 8000;
	public static final String ANIMATION_IMAGE_PREFIX = "paralyze_";
	
	public ParalyzeAnimation(Paralyze paralyze, Pig pig, Enemy enemy) {
		super(paralyze, pig, enemy);
		
		setDelay(DURATION_STOP_NUTRITIONIST_MOVE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		Enemy enemy = (Enemy) getElementToAct();
		
		BufferedImage image;
		
		if (count == 0) {
			enemy.setMovable(false);
			enemy.setPowerful(false);
			
			image = ImageLoader.loadFromPath(ANIMATION_IMAGE_PREFIX + enemy.getImageName());
			enemy.setImageWithDimension(image);
		} else {
			timer.stop();
			
			image = ImageLoader.loadFromPath(enemy.getImageName());
			enemy.setImageWithDimension(image);
			
			enemy.setMovable(true);
			enemy.setPowerful(true);
		}
	}
}
