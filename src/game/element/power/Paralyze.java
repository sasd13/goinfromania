package game.element.power;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import game.element.character.Character;
import game.element.character.Nutritionist;

public class Paralyze extends Power {

	public static final String NAME = "Paralyze";
	public static final String ANIMATION_IMAGE_PREFIX = "paralyze_";
	
	/*
	 * Paralyse le nutritioniste pendant 5 secondes
	 * Empeche son attaque
	 */
	public static final int VALUE_STOP_NUTRITIONIST_MOVE = 5;
	
	private int value;
	
	public Paralyze() {
		super();
		
		setName(NAME);
		
		this.value = VALUE_STOP_NUTRITIONIST_MOVE;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
		
		setChanged();
		notifyObservers();
	}

	@Override
	public void act(Character character) {
		if (character instanceof Nutritionist) {
			Nutritionist nutritionist = (Nutritionist) character;
			
			nutritionist.setMovable(false);
			nutritionist.setPowerful(false);
			endParalyzeAct(nutritionist);
			
			super.act(character);
		}
	}
	
	private synchronized void endParalyzeAct(final Nutritionist nutritionist) {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				nutritionist.setMovable(true);
				nutritionist.setPowerful(true);
				scheduler.shutdown();
			}
		};
		
		scheduler.schedule(runnable, getValue(), TimeUnit.MILLISECONDS);
	}
}
