package game.round;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import game.Game;
import game.GameController;
import game.element.character.Life;
import game.element.character.Pig;
import game.round.Round;
import game.round.RoundManager;
import game.round.RoundResult;
import game.setting.Level;
import game.view.RoundView;

public class RoundController {

	private Round round;
	private RoundView roundView;
	
	public RoundController(Round round, RoundView roundView) {
		this.round = round;
		this.roundView = roundView;
		
		this.round.addObserver(this.roundView);
	}
	
	private void update() {
		this.roundView.update(this.round, null);
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
		
		update();
	}
	
	public void resume() {
		
	}
	
	public void pause() {
		
	}
	
	public void stop() {
		RoundResult roundResult = null;
		
		if (this.round.isFinished()) {
			Pig pig = this.round.getPig();
			if (!pig.isDied()) {
				roundResult = RoundResult.WIN;
			} else {
				roundResult = RoundResult.LOOSE;
			}
		} else {
			roundResult = RoundResult.PROGRESS;
		}
		
		exitRound(roundResult);
	}
	
	public void exitRound(RoundResult roundResult) {
		this.round.deleteObserver(this.roundView);
		Game.getInstance().setLiveRound(null);
		
		String title = null;
		String message = null;
		int selected;
		
		switch (roundResult) {
			case WIN :
				Game.getInstance().getListRound().remove(this.round);
				
				title = "Result";
				message = "YOU WIN!!! Score : " + this.round.getCumulatedScore().getValue();
				
				JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
				GameController.getInstance().showListRounds();
				break;
			case LOOSE :
				Game.getInstance().getListRound().remove(this.round);
				
				title = "Result";
				message = "YOU LOOSE... New Round?";
				
				selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
				switch (selected) {
					case JOptionPane.YES_OPTION :
						GameController.getInstance().newRound();
						break;
					case JOptionPane.NO_OPTION :
						GameController.getInstance().showListRounds();
						break;					
				}
				break;
			case PROGRESS :
				title = "Exit round";
				message = "Save your progress?";
				
				selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
				switch (selected) {
					case JOptionPane.YES_OPTION :
						RoundManager.save(this.round);
						break;					
				}
				GameController.getInstance().showListRounds();
				break;
		}
	}
	
	public void checkEatenCake() {
		Level level = this.round.getLevel();
		
		Pig pig = this.round.getPig();
		int countEatenCake = pig.getCountEatenCake();
		
		if ((level == Level.EASY && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_EASY) 
				|| (level == Level.NORMAL && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_NORMAL)
				|| level == Level.HARD && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_HARD) {
			this.round.setFinished(true);
			stop();
		}
	}
	
	public void checkPigLife() {
		Pig pig = this.round.getPig();
		
		Life life = pig.getLife();
		
		if (life.getValue() == Life.LIFE_MIN) {
			this.round.setFinished(true);
			stop();
		}
	}
}
