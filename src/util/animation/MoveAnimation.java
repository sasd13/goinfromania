package util.animation;

import java.awt.event.ActionEvent;

import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.item.Wall;
import util.ArenaUtil;
import controller.ArenaController;

public class MoveAnimation extends Animation {

	public static final int DEFAULT_DELAY = 800;
	
	private ListElements listElements;
	
	public MoveAnimation(ListElements listElements) {
		this.listElements = listElements;
		
		setDelay(DEFAULT_DELAY);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Direction direction;
		
		Element element;
		for (int i=0; i<this.listElements.size(); i++) {
			element = this.listElements.get(i);
			
			if (element instanceof Pig || element instanceof Wall) {
				continue;
			} else if (element instanceof Nutritionist || element instanceof Virus) {
				direction = ArenaUtil.pursuePig((Enemy) element, this.listElements.getPig());
			} else {
				direction = ArenaUtil.getRandomDirection(element);
				
				boolean canMove = ArenaUtil.canMoveInDirection(element, direction, this.listElements);
				if (!canMove) {
					direction = ArenaUtil.getOpositeDirection(direction);
				}	
			}
				
			ArenaController.actionMove(element, direction);
		}
	}
}