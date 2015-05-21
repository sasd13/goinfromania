package anim;

import java.awt.event.ActionEvent;

import util.ArenaUtil;
import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.food.Food;
import controller.ArenaController;

public class AutoMoveAnimation extends Animation {

	public static final int DELAY_MOVE = 70;
	
	private ListElements listElements;
	
	public AutoMoveAnimation(ListElements listElements) {
		this.listElements = listElements;
		
		setDelay(DELAY_MOVE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Direction direction;
		
		Element element;
		for (int i=0; i<this.listElements.size(); i++) {
			element = this.listElements.get(i);
			
			if (element instanceof Enemy) {
				direction = ArenaUtil.pursue(element, this.listElements.getPig());
				
				ArenaController.actionMove(element, direction);
			} else if (element instanceof Food){
				direction = ArenaUtil.getRandomDirection(element);
				
				boolean canMove = ArenaUtil.canMoveInDirection(element, direction, this.listElements);
				if (!canMove) {
					direction = ArenaUtil.getOpositeDirection(direction);
				}
				
				ArenaController.actionMove(element, direction);
			}
		}
	}
}