package game.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.item.Trap;
import game.element.item.Wall;
import game.util.ArenaUtil;

import javax.swing.Timer;

import controller.ArenaController;

public class MoveScheduler implements ActionListener {

	public static final int DEFAULT_DELAY = 800;
	
	private ListElements listElements;
	
	private Timer timer;
	
	public MoveScheduler(ListElements listElements) {
		this.listElements = listElements;
		
		this.timer = new Timer(200, this);
		this.timer.setDelay(DEFAULT_DELAY);
	}
	
	public MoveScheduler(ListElements listElements, int delay) {
		this(listElements);
		
		setDelay(delay);
	}
	
	public int getInitialDelay() {
		return this.timer.getInitialDelay();
	}
	
	public void setInitialDelay(int initialDelay) {
		this.timer.setInitialDelay(initialDelay);
	}
	
	public int getDelay() {
		return this.timer.getDelay();
	}
	
	public void setDelay(int delay) {
		this.timer.setDelay(delay);
	}
	
	public void start() {
		this.timer.start();
	}
	
	public void restart() {
		this.timer.restart();
	}
	
	public void stop() {
		this.timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Element element;
		for (int i=0; i<this.listElements.size(); i++) {
			element = this.listElements.get(i);
			
			if (element instanceof Pig
					|| element instanceof Wall
					|| element instanceof Trap) {
				continue;
			} else {
				Direction direction = Direction.LEFT;
				
				if (element instanceof Cake) {
					direction = ArenaUtil.draw(element, this.listElements);
				} else if (element instanceof Nutritionist
						|| element instanceof Virus) {
					direction = ArenaUtil.pursuePig((Enemy) element, this.listElements.getPig());
				}
				
				ArenaController.actionMove(element, direction);
			}
		}
	}
}
