package util.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.element.Element;
import game.element.ListElements;
import game.element.character.Nutritionist;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.PoisonCake;
import game.element.item.Wall;
import game.round.Level;

import javax.swing.Timer;

public class AppearanceScheduler implements ActionListener {

	private final int FACTOR_CAKE_APPEARANCE_LEVEL_EASY = 7;
	private final int FACTOR_CAKE_APPEARANCE_LEVEL_NORMAL = 3;
	private final int FACTOR_CAKE_APPEARANCE_LEVEL_HARD = 1;
	public static final int DEFAULT_DELAY = 3000;
	
	private ListElements listElements;
	private Level level;
	private int factorCakeAppearance;
	
	private Timer timer;
	
	public AppearanceScheduler(ListElements listElements, Level level) {
		this.listElements = listElements;
		this.level = level;
		
		switch (this.level) {
			case EASY :
				this.factorCakeAppearance = FACTOR_CAKE_APPEARANCE_LEVEL_EASY;
				break;
			case NORMAL :
				this.factorCakeAppearance = FACTOR_CAKE_APPEARANCE_LEVEL_NORMAL;
				break;
			case HARD :
				this.factorCakeAppearance = FACTOR_CAKE_APPEARANCE_LEVEL_HARD;
				break;
		}
		
		this.timer = new Timer(200, this);
		this.timer.setDelay(DEFAULT_DELAY);
	}
	
	public AppearanceScheduler(ListElements listElements, Level level, int delay) {
		this(listElements, level);
		
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
		
		int random = (int) (Math.random()*(this.factorCakeAppearance+4) + 1);
		
		if (random <= this.factorCakeAppearance) {
			element = new Cake();
		} else if (random == this.factorCakeAppearance+1) {
			element = new Nutritionist();
		} else if (random == this.factorCakeAppearance+2) {
			element = new Virus();
		} else if (random == this.factorCakeAppearance+3) {
			element = new PoisonCake();
		} else {
			element = new Wall();
		}
		
		new AppearancePositionWorker(element, this.listElements).execute();
	}
}