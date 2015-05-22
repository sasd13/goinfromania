package anim;

import java.awt.event.ActionEvent;

import util.ArenaUtil;
import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.round.Level;
import controller.ArenaController;

public class EnemyAutoMoveAnimation extends Animation {

	public static final int DELAY_LEVEL_EASY = 32;
	public static final int DELAY_LEVEL_NORMAL = 16;
	public static final int DELAY_LEVEL_HARD = 8;
	
	private Level level;
	private ListElements listElements;
	
	public EnemyAutoMoveAnimation(Level level, ListElements listElements) {
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
			
			if (element instanceof Enemy) {
				direction = ArenaUtil.pursue(element, this.listElements.getPig());
				
				ArenaController.actionMove(element, direction);
			}
		}
	}
}