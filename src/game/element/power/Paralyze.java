package game.element.power;

import java.util.Timer;
import java.util.TimerTask;

import game.element.character.Character;
import game.element.character.Nutritionist;

public class Paralyze extends Power {

	/*
	 * Paralyse le nutritioniste pendant 5 secondes
	 * Empeche son attaque
	 */
	public static final String NAME = "Paralyze";
	public static final int POWER_VALUE_PARALYZE_NUTRITIONIST = 5;
	
	private Timer timerPower;
	
	public Paralyze() {
		super();
		
		setName(NAME);
		setValue(POWER_VALUE_PARALYZE_NUTRITIONIST);
	}

	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		this.timerPower = new Timer();
		
		nutritionist.setMovable(false);
		nutritionist.setPowerful(false);
		endPowerAct(nutritionist);
	}
	
	private synchronized void endPowerAct(final Nutritionist nutritionist) {
		this.timerPower.cancel();
		this.timerPower = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				nutritionist.setMovable(true);
				nutritionist.setPowerful(true);
			}
		};
		
		this.timerPower.schedule(task, getValue());
	}
}
