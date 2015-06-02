package main.java.controller.anim.arena;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutionException;

import main.java.controller.ArenaController;
import main.java.controller.anim.Animation;
import main.java.game.element.Element;
import main.java.game.element.ListElements;
import main.java.game.element.character.Nutritionist;
import main.java.game.element.character.Virus;
import main.java.game.element.food.CherryCake;
import main.java.game.element.food.ChocolateCake;
import main.java.game.element.food.KiwiCake;
import main.java.game.element.food.RaisinCake;
import main.java.game.element.food.StrawberryCake;
import main.java.game.element.item.Wall;
import main.java.game.round.Level;

public class AutoAppearanceAnimation extends Animation {

	private final int FACTOR_APPEARANCE_STRAWBERRYCAKE_LEVEL_EASY = 0;
	private final int FACTOR_APPEARANCE_STRAWBERRYCAKE_LEVEL_NORMAL = 0;
	private final int FACTOR_APPEARANCE_STRAWBERRYCAKE_LEVEL_HARD = 0;
	
	private final int FACTOR_APPEARANCE_CHOCOLATECAKE_LEVEL_EASY = 2;
	private final int FACTOR_APPEARANCE_CHOCOLATECAKE_LEVEL_NORMAL = 4;
	private final int FACTOR_APPEARANCE_CHOCOLATECAKE_LEVEL_HARD = 6;
	
	private final int FACTOR_APPEARANCE_RAISINCAKE_LEVEL_EASY = 12;
	private final int FACTOR_APPEARANCE_RAISINCAKE_LEVEL_NORMAL = 24;
	private final int FACTOR_APPEARANCE_RAISINCAKE_LEVEL_HARD = 36;
	
	private final int FACTOR_APPEARANCE_CHERRYCAKE_LEVEL_EASY = 6;
	private final int FACTOR_APPEARANCE_CHERRYCAKE_LEVEL_NORMAL = 12;
	private final int FACTOR_APPEARANCE_CHERRYCAKE_LEVEL_HARD = 18;
	
	private final int FACTOR_APPEARANCE_KIWICAKE_LEVEL_EASY = 14;
	private final int FACTOR_APPEARANCE_KIWICAKE_LEVEL_NORMAL = 28;
	private final int FACTOR_APPEARANCE_KIWICAKE_LEVEL_HARD = 42;
	
	private final int FACTOR_APPEARANCE_VIRUS_LEVEL_EASY = 22;
	private final int FACTOR_APPEARANCE_VIRUS_LEVEL_NORMAL = 40;
	private final int FACTOR_APPEARANCE_VIRUS_LEVEL_HARD = 60;
	
	private final int FACTOR_APPEARANCE_NUTRITIONIST_LEVEL_EASY = 26;
	private final int FACTOR_APPEARANCE_NUTRITIONIST_LEVEL_NORMAL = 48;
	private final int FACTOR_APPEARANCE_NUTRITIONIST_LEVEL_HARD = 72;
	
	private final int FACTOR_APPEARANCE_WALL_LEVEL_EASY = 28;
	private final int FACTOR_APPEARANCE_WALL_LEVEL_NORMAL = 52;
	private final int FACTOR_APPEARANCE_WALL_LEVEL_HARD = 78;
	
	public static final int DELAY_LEVEL_EASY = 3600;
	public static final int DELAY_LEVEL_NORMAL = 2400;
	public static final int DELAY_LEVEL_HARD = 1200;
	
	private Level level;
	private ListElements listElements;
	
	private int factorAppearanceRaisinCake,
		factorAppearanceChocolateCake,
		factorAppearanceStrawberryCake,
		factorAppearanceCherryCake,
		factorAppearanceKiwiCake,
		factorAppearanceNutritionist,
		factorAppearanceVirus,
		factorAppearanceWall;
	
	private AutoAppearancePositionWorker autoAppearancePositionWorker;
	
	public AutoAppearanceAnimation(Level level, ListElements listElements) {
		super();
		
		setLevel(level);
		
		this.listElements = listElements;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
		
		setParameters(level);
	}
	
	public ListElements getListElements() {
		return this.listElements;
	}
	
	public void setListElements(ListElements listElements) {
		this.listElements = listElements;
	}
	
	private void setParameters(Level level) {
		switch (level) {
			case EASY :
				setDelay(DELAY_LEVEL_EASY);
				
				this.factorAppearanceStrawberryCake = FACTOR_APPEARANCE_STRAWBERRYCAKE_LEVEL_EASY;
				this.factorAppearanceChocolateCake = FACTOR_APPEARANCE_CHOCOLATECAKE_LEVEL_EASY;
				this.factorAppearanceRaisinCake = FACTOR_APPEARANCE_RAISINCAKE_LEVEL_EASY;
				this.factorAppearanceCherryCake = FACTOR_APPEARANCE_CHERRYCAKE_LEVEL_EASY;
				this.factorAppearanceKiwiCake = FACTOR_APPEARANCE_KIWICAKE_LEVEL_EASY;
				this.factorAppearanceVirus = FACTOR_APPEARANCE_VIRUS_LEVEL_EASY;
				this.factorAppearanceNutritionist = FACTOR_APPEARANCE_NUTRITIONIST_LEVEL_EASY;
				this.factorAppearanceWall = FACTOR_APPEARANCE_WALL_LEVEL_EASY;
				break;
			case NORMAL :
				setDelay(DELAY_LEVEL_NORMAL);
				
				this.factorAppearanceStrawberryCake = FACTOR_APPEARANCE_STRAWBERRYCAKE_LEVEL_NORMAL;
				this.factorAppearanceChocolateCake = FACTOR_APPEARANCE_CHOCOLATECAKE_LEVEL_NORMAL;
				this.factorAppearanceRaisinCake = FACTOR_APPEARANCE_RAISINCAKE_LEVEL_NORMAL;
				this.factorAppearanceCherryCake = FACTOR_APPEARANCE_CHERRYCAKE_LEVEL_NORMAL;
				this.factorAppearanceKiwiCake = FACTOR_APPEARANCE_KIWICAKE_LEVEL_NORMAL;
				this.factorAppearanceVirus = FACTOR_APPEARANCE_VIRUS_LEVEL_NORMAL;
				this.factorAppearanceNutritionist = FACTOR_APPEARANCE_NUTRITIONIST_LEVEL_NORMAL;
				this.factorAppearanceWall = FACTOR_APPEARANCE_WALL_LEVEL_NORMAL;
				break;
			case HARD :
				setDelay(DELAY_LEVEL_HARD);
				
				this.factorAppearanceStrawberryCake = FACTOR_APPEARANCE_STRAWBERRYCAKE_LEVEL_HARD;
				this.factorAppearanceChocolateCake = FACTOR_APPEARANCE_CHOCOLATECAKE_LEVEL_HARD;
				this.factorAppearanceRaisinCake = FACTOR_APPEARANCE_RAISINCAKE_LEVEL_HARD;
				this.factorAppearanceCherryCake = FACTOR_APPEARANCE_CHERRYCAKE_LEVEL_HARD;
				this.factorAppearanceKiwiCake = FACTOR_APPEARANCE_KIWICAKE_LEVEL_HARD;
				this.factorAppearanceVirus = FACTOR_APPEARANCE_VIRUS_LEVEL_HARD;
				this.factorAppearanceNutritionist = FACTOR_APPEARANCE_NUTRITIONIST_LEVEL_HARD;
				this.factorAppearanceWall = FACTOR_APPEARANCE_WALL_LEVEL_HARD;
				break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Element element = null;
		
		int random = (int) (Math.random()*this.factorAppearanceWall);
		
		if (random <= this.factorAppearanceStrawberryCake) {
			element = new StrawberryCake();
		} else if (random <= this.factorAppearanceChocolateCake) {
			element = new ChocolateCake();
		} else if (random <= this.factorAppearanceRaisinCake) {
			element = new RaisinCake();
		} else if (random <= this.factorAppearanceCherryCake) {
			element = new CherryCake();
		} else if (random <= this.factorAppearanceKiwiCake) {
			element = new KiwiCake();
		} else if (random <= this.factorAppearanceVirus) {
			element = new Virus();
		} else if (random <= this.factorAppearanceNutritionist) {
			element = new Nutritionist();
		} else {
			element = new Wall();
		}
		
		this.autoAppearancePositionWorker = new AutoAppearancePositionWorker(element, this.listElements);
		this.autoAppearancePositionWorker.execute();
		
		try {
			Point position = (Point) this.autoAppearancePositionWorker.get();
			element.setPosition(position);
			
			ArenaController.addElement(element);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}