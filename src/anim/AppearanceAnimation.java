package anim;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutionException;

import controller.RoundController;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Nutritionist;
import game.element.character.Virus;
import game.element.food.CherryCake;
import game.element.food.ChocolateCake;
import game.element.food.KiwiCake;
import game.element.food.MousseCake;
import game.element.food.RaisinCake;
import game.element.food.StrawberryCake;
import game.element.item.Wall;
import game.round.Level;

public class AppearanceAnimation extends Animation {

	private final int FACTOR_STRAWBERRYCAKE_APPEARANCE_LEVEL_EASY = 0;
	private final int FACTOR_STRAWBERRYCAKE_APPEARANCE_LEVEL_NORMAL = 0;
	private final int FACTOR_STRAWBERRYCAKE_APPEARANCE_LEVEL_HARD = 0;
	
	private final int FACTOR_CHOCOLATECAKE_APPEARANCE_LEVEL_EASY = 2;
	private final int FACTOR_CHOCOLATECAKE_APPEARANCE_LEVEL_NORMAL = 4;
	private final int FACTOR_CHOCOLATECAKE_APPEARANCE_LEVEL_HARD = 6;
	
	private final int FACTOR_CHERRYCAKE_APPEARANCE_LEVEL_EASY = 6;
	private final int FACTOR_CHERRYCAKE_APPEARANCE_LEVEL_NORMAL = 12;
	private final int FACTOR_CHERRYCAKE_APPEARANCE_LEVEL_HARD = 18;
	
	private final int FACTOR_RAISINCAKE_APPEARANCE_LEVEL_EASY = 12;
	private final int FACTOR_RAISINCAKE_APPEARANCE_LEVEL_NORMAL = 24;
	private final int FACTOR_RAISINCAKE_APPEARANCE_LEVEL_HARD = 36;
	
	private final int FACTOR_KIWICAKE_APPEARANCE_LEVEL_EASY = 16;
	private final int FACTOR_KIWICAKE_APPEARANCE_LEVEL_NORMAL = 32;
	private final int FACTOR_KIWICAKE_APPEARANCE_LEVEL_HARD = 48;
	
	private final int FACTOR_MOUSSECAKE_APPEARANCE_LEVEL_EASY = 22;
	private final int FACTOR_MOUSSECAKE_APPEARANCE_LEVEL_NORMAL = 46;
	private final int FACTOR_MOUSSECAKE_APPEARANCE_LEVEL_HARD = 64;
	
	private final int FACTOR_VIRUS_APPEARANCE_LEVEL_EASY = 26;
	private final int FACTOR_VIRUS_APPEARANCE_LEVEL_NORMAL = 54;
	private final int FACTOR_VIRUS_APPEARANCE_LEVEL_HARD = 76;
	
	private final int FACTOR_NUTRITIONIST_APPEARANCE_LEVEL_EASY = 32;
	private final int FACTOR_NUTRITIONIST_APPEARANCE_LEVEL_NORMAL = 66;
	private final int FACTOR_NUTRITIONIST_APPEARANCE_LEVEL_HARD = 94;
	
	private final int FACTOR_WALL_APPEARANCE_LEVEL_EASY = 36;
	private final int FACTOR_WALL_APPEARANCE_LEVEL_NORMAL = 74;
	private final int FACTOR_WALL_APPEARANCE_LEVEL_HARD = 106;
	
	public static final int DELAY_LEVEL_EASY = 3600;
	public static final int DELAY_LEVEL_NORMAL = 2400;
	public static final int DELAY_LEVEL_HARD = 1200;
	
	private ListElements listElements;
	private Level level;
	private int factorRaisinCakeAppearance,
		factorCherryCakeAppearance,
		factorChocolateCakeAppearance,
		factorStrawberryCakeAppearance,
		factorMousseCakeAppearance,
		factorKiwiCakeAppearance,
		factorNutritionistAppearance,
		factorVirusAppearance,
		factorWallAppearance;
	
	public AppearanceAnimation(ListElements listElements, Level level) {
		this.listElements = listElements;
		this.level = level;
		
		switch (this.level) {
			case EASY :
				this.factorStrawberryCakeAppearance = FACTOR_STRAWBERRYCAKE_APPEARANCE_LEVEL_EASY;
				this.factorChocolateCakeAppearance = FACTOR_CHOCOLATECAKE_APPEARANCE_LEVEL_EASY;
				this.factorCherryCakeAppearance = FACTOR_CHERRYCAKE_APPEARANCE_LEVEL_EASY;
				this.factorRaisinCakeAppearance = FACTOR_RAISINCAKE_APPEARANCE_LEVEL_EASY;
				this.factorKiwiCakeAppearance = FACTOR_KIWICAKE_APPEARANCE_LEVEL_EASY;
				this.factorMousseCakeAppearance = FACTOR_MOUSSECAKE_APPEARANCE_LEVEL_EASY;
				this.factorVirusAppearance = FACTOR_VIRUS_APPEARANCE_LEVEL_EASY;
				this.factorNutritionistAppearance = FACTOR_NUTRITIONIST_APPEARANCE_LEVEL_EASY;
				this.factorWallAppearance = FACTOR_WALL_APPEARANCE_LEVEL_EASY;
				
				setDelay(DELAY_LEVEL_EASY);
				break;
			case NORMAL :
				this.factorStrawberryCakeAppearance = FACTOR_STRAWBERRYCAKE_APPEARANCE_LEVEL_NORMAL;
				this.factorChocolateCakeAppearance = FACTOR_CHOCOLATECAKE_APPEARANCE_LEVEL_NORMAL;
				this.factorCherryCakeAppearance = FACTOR_CHERRYCAKE_APPEARANCE_LEVEL_NORMAL;
				this.factorRaisinCakeAppearance = FACTOR_RAISINCAKE_APPEARANCE_LEVEL_NORMAL;
				this.factorKiwiCakeAppearance = FACTOR_KIWICAKE_APPEARANCE_LEVEL_NORMAL;
				this.factorMousseCakeAppearance = FACTOR_MOUSSECAKE_APPEARANCE_LEVEL_NORMAL;
				this.factorVirusAppearance = FACTOR_VIRUS_APPEARANCE_LEVEL_NORMAL;
				this.factorNutritionistAppearance = FACTOR_NUTRITIONIST_APPEARANCE_LEVEL_NORMAL;
				this.factorWallAppearance = FACTOR_WALL_APPEARANCE_LEVEL_NORMAL;
				
				setDelay(DELAY_LEVEL_NORMAL);
				break;
			case HARD :
				this.factorStrawberryCakeAppearance = FACTOR_STRAWBERRYCAKE_APPEARANCE_LEVEL_HARD;
				this.factorChocolateCakeAppearance = FACTOR_CHOCOLATECAKE_APPEARANCE_LEVEL_HARD;
				this.factorCherryCakeAppearance = FACTOR_CHERRYCAKE_APPEARANCE_LEVEL_HARD;
				this.factorRaisinCakeAppearance = FACTOR_RAISINCAKE_APPEARANCE_LEVEL_HARD;
				this.factorKiwiCakeAppearance = FACTOR_KIWICAKE_APPEARANCE_LEVEL_HARD;
				this.factorMousseCakeAppearance = FACTOR_MOUSSECAKE_APPEARANCE_LEVEL_HARD;
				this.factorVirusAppearance = FACTOR_VIRUS_APPEARANCE_LEVEL_HARD;
				this.factorNutritionistAppearance = FACTOR_NUTRITIONIST_APPEARANCE_LEVEL_HARD;
				this.factorWallAppearance = FACTOR_WALL_APPEARANCE_LEVEL_HARD;
				
				setDelay(DELAY_LEVEL_HARD);
				break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Element element = null;
		
		int random = (int) (Math.random()*this.factorWallAppearance);
		
		if (random <= this.factorStrawberryCakeAppearance) {
			element = new StrawberryCake();
		} else if (random <= this.factorChocolateCakeAppearance) {
			element = new ChocolateCake();
		} else if (random <= this.factorCherryCakeAppearance) {
			element = new CherryCake();
		} else if (random <= this.factorRaisinCakeAppearance) {
			element = new RaisinCake();
		} else if (random <= this.factorKiwiCakeAppearance) {
			element = new KiwiCake();
		} else if (random <= this.factorMousseCakeAppearance) {
			element = new MousseCake();
		} else if (random <= this.factorVirusAppearance) {
			element = new Virus();
		} else if (random <= this.factorNutritionistAppearance) {
			element = new Nutritionist();
		} else {
			element = new Wall();
		}
		
		AppearancePositionWorker appearancePositionWorker = new AppearancePositionWorker(element, this.listElements);
		appearancePositionWorker.execute();
		
		try {
			Point position = (Point) appearancePositionWorker.get();
			element.setPosition(position);
			
			this.listElements.add(element);
			RoundController.checkListElementsSize();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}