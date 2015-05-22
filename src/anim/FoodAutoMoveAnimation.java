package anim;

import java.awt.event.ActionEvent;

import util.ArenaUtil;
import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.food.Food;
import game.round.Level;
import controller.ArenaController;

public class FoodAutoMoveAnimation extends Animation {

	public static final int DELAY_LEVEL_EASY = 64;
	public static final int DELAY_LEVEL_NORMAL = 32;
	public static final int DELAY_LEVEL_HARD = 16;
	
	private Level level;
	private ListElements listElements;
	
	public FoodAutoMoveAnimation(Level level, ListElements listElements) {
		super();
		
		setLevel(level);
		
		this.listElements = listElements;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
		
		setParams(level);
	}
	
	public ListElements getListElements() {
		return this.listElements;
	}
	
	public void setListElements(ListElements listElements) {
		this.listElements = listElements;
	}
	
	private void setParams(Level level) {
		switch (level) {
			case EASY :
				setDelay(DELAY_LEVEL_EASY);
				break;
			case NORMAL :
				setDelay(DELAY_LEVEL_NORMAL);
				break;
			case HARD :
				setDelay(DELAY_LEVEL_HARD);
				break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Direction direction;
		
		Element element;
		for (int i=0; i<this.listElements.size(); i++) {
			element = this.listElements.get(i);
			
			if (element instanceof Food) {
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