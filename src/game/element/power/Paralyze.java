package game.element.power;

import java.util.Timer;
import java.util.TimerTask;

import game.element.character.Character;
import game.element.character.Nutritionist;

public class Paralyze extends Power {

	public static final String NAME = "Paralyze";
	
	/*
	 * Paralyse le nutritioniste pendant 5 secondes
	 * Empeche son attaque
	 */
	public static final int VALUE_STOP_NUTRITIONIST_MOVE = 5;
	
	private int value;
	
	private Timer timerParalyze;
	
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
		if (character.getName().compareTo(Nutritionist.NAME) == 0) {
			Nutritionist nutritionist = (Nutritionist) character;
			
			this.timerParalyze = new Timer();
			
			nutritionist.setMovable(false);
			nutritionist.setPowerful(false);
			endParalyzeAct(nutritionist);
		}
	}
	
	private synchronized void endParalyzeAct(final Nutritionist nutritionist) {
		this.timerParalyze.cancel();
		this.timerParalyze = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				nutritionist.setMovable(true);
				nutritionist.setPowerful(true);
			}
		};
		
		this.timerParalyze.schedule(task, getValue());
	}
}
