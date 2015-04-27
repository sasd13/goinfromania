package game.round;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import game.GameController;
import game.element.Element;
import game.element.ListElement;
import game.element.character.Pig;
import game.round.Round;
import game.round.RoundManager;
import game.round.Result;
import game.view.RoundView;

public class RoundController {

	private Round round;
	private RoundView roundView;
	
	public RoundController(Round round, RoundView roundView) {
		this.round = round;
		this.roundView = roundView;
		
		this.round.addObserver(this.roundView);
		this.roundView.update(this.round, null);
	}
	
	public void checkPigLife() {
		Pig pig = this.round.getPig();
		
		if (pig.isDied()) {
			this.round.setFinished(true);
			stop();
		}
	}
	
	public void checkEatenCake() {
		Level level = this.round.getLevel();
		
		Pig pig = this.round.getPig();
		int countEatenCake = pig.getCountEatenCake();
		
		if ((level == Level.EASY && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_EASY)
				|| (level == Level.NORMAL && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_NORMAL)
				|| (level == Level.HARD && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_HARD)) {
			this.round.setFinished(true);
			stop();
		}
	}
	
	public void checkListElement() {
		ListElement listElement = this.round.getListElement();
		
		Element element;
		for(int i=0; i<listElement.size(); i++) {
			element = listElement.get(i);
			
			if (!element.isVisible()) {
				listElement.remove(element);
			}
		}
	}
	
	public void start() {
		GridListener listener = new GridListener(this, this.round);
		
		JButton buttonPigAttak = this.roundView.getButtonPigAttak();
		buttonPigAttak.addActionListener(listener);
		
		JButton buttonPigEatCake = this.roundView.getButtonPigEatCake();
		buttonPigEatCake.addActionListener(listener);
		
		JButton buttonPigEatPoisonCake = this.roundView.getButtonPigEatPoisonCake();
		buttonPigEatPoisonCake.addActionListener(listener);
		
		JButton buttonNutritionistAttak = this.roundView.getButtonNutritionistAttak();
		buttonNutritionistAttak.addActionListener(listener);
		
		JButton buttonVirusAttak = this.roundView.getButtonVirusAttak();
		buttonVirusAttak.addActionListener(listener);
	}
	
	public void resume() {
		
	}
	
	public void pause() {
		
	}
	
	public void stop() {
		if (this.round.isFinished()) {
			Pig pig = this.round.getPig();
			
			if (!pig.isDied()) {
				this.round.setResult(Result.WIN);
			} else {
				this.round.setResult(Result.LOOSE);
			}
		} else {
			this.round.setResult(Result.PROGRESS);
		}
		
		String title = null;
		String message = null;
		int selected;
		
		switch (this.round.getResult()) {
			case WIN :
				
				title = "Result";
				message = "YOU WIN :-)!!! Score : " + this.round.getCumulatedScore().getValue();
				
				JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
				break;
			case LOOSE :
				
				title = "Result";
				message = "YOU LOOSE... :-(";
				
				JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
				break;
			case PROGRESS :
				title = "Exit round";
				message = "Save your progress?";
				
				selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
				switch (selected) {
					case JOptionPane.YES_OPTION :
						saveRound();
						break;					
				}
				break;
		}
		
		GameController.getInstance().closeRound(this.round);
	}
	
	public void saveRound() {
		if (!this.round.isFinished()) {
			RoundManager.save(this.round);
		}
	}
}
