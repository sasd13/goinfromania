package game.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.element.Element;
import game.element.ListElements;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.PoisonCake;
import game.element.item.Wall;

import javax.swing.Timer;

public class AppearanceScheduler implements ActionListener {

	public static final int DEFAULT_DELAY = 4000;
	
	private ListElements listElements;
	
	private Timer timer;
	
	public AppearanceScheduler(ListElements listElements) {
		this.listElements = listElements;
		
		this.timer = new Timer(200, this);
		this.timer.setDelay(DEFAULT_DELAY);
	}
	
	public AppearanceScheduler(ListElements listElements, int delay) {
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
		Element element = null;
		
		int random = (int) (Math.random()*5);
		
		switch (random) {
			case 0 :
				element = new Cake();
				break;
			case 1 :
				element = new PoisonCake();
				break;
			case 2 :
				element = new Nutritionist();
				break;
			case 3 : 
				element = new Virus();
				break;
			case 4 : 
				element = new Wall();
				break;
			case 5 : 
				element = new Wall();
				break;
			default :
				break;
		}
		
		Pig pig = this.listElements.getPig();
		
		new AppearancePositionWorker(element, this.listElements).execute();
		
		this.listElements.add(element);
	}
}
