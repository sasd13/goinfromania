package controller;

import javax.swing.JOptionPane;

import view.ArenaView;
import view.PigStateView;
import view.RoundView;
import db.RoundDAO;
import db.SettingDAO;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Character;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.power.Diet;
import game.element.power.Disease;
import game.element.power.Power;
import game.round.GamePadListener;
import game.round.ArenaListener;
import game.round.Level;
import game.round.Result;
import game.round.Round;
import game.round.ScoreConstantes;
import game.round.State;
import game.setting.Direction;
import game.setting.GamePad;

public class RoundController {

	private Round round;
	private RoundView roundView;
	
	private GamePad gamePad;
	private PigStateView pigStateView;
	private ArenaView arenaView;
	
	public RoundController(Round round, RoundView roundView) {
		this.round = round;
		this.roundView = roundView;
		
		this.round.addObserver(this.roundView);
		this.roundView.update(this.round, null);
		
		this.arenaView = this.roundView.getArenaView();
		ListElements listElements = this.round.getListElement();
		listElements.addObserver(this.arenaView);
		this.arenaView.update(listElements, null);
		
		this.pigStateView = this.roundView.getPigStateView();
		Pig pig = this.round.getPig();
		pig.addObserver(this.pigStateView);
		this.pigStateView.update(pig, null);
	}
	
	public void start() {
		this.round.setState(State.STARTED);
		
		this.gamePad = loadGamePad();
		
		GamePadListener gamePadListener = new GamePadListener(this);
		this.arenaView.addKeyListener(gamePadListener);
		this.arenaView.setFocusable(true);
		this.arenaView.requestFocusInWindow();
		
		ArenaListener listener = new ArenaListener(this);
		this.arenaView.getButtonPigEatCake().addActionListener(listener);
		this.arenaView.getButtonPigEatPoisonCake().addActionListener(listener);
		this.arenaView.getButtonNutritionistAttak().addActionListener(listener);
		this.arenaView.getButtonVirusAttak().addActionListener(listener);
	}
	
	public void restart() {
		this.round.setState(State.STARTED);
		
		this.gamePad = loadGamePad();
	}
	
	public void resume() {
		this.round.setState(State.STARTED);
		
		this.gamePad = loadGamePad();
	}
	
	public void pause() {
		this.round.setState(State.PAUSED);
	}
	
	public void stop() {
		this.round.setState(State.STOPPED);
		
		String title = null;
		String message = null;
		
		if (!this.round.isFinished()) {
			title = "Exit round";
			message = "Save your progress?";
			
			int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
			switch (selected) {
				case JOptionPane.YES_OPTION :
					save();
					break;					
			}
		} else {
			title = "Result";
			
			if (this.round.getPig().isDied()) {
				this.round.setResult(Result.LOOSE);
				message = "YOU LOOSE... :-(";
			} else {
				this.round.setResult(Result.WIN);
				message = "YOU WIN :-)!!! Score : " + this.round.getScore();
			}
			
			JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
		}
		
		GameController.getInstance().closeRound(this.round);
	}
	
	public GamePad loadGamePad() {
		GamePad gamePad = (GamePad) SettingDAO.load(GamePad.NAME);
		
		return gamePad;
	}
	
	public void save() {
		if (!this.round.isFinished()) {
			RoundDAO.save(this.round);
		}
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
		ListElements listElements = this.round.getListElement();
		
		Element element;
		for(int i=0; i<listElements.size(); i++) {
			element = listElements.get(i);
			
			if (!element.isVisible()) {
				listElements.remove(element);
			}
		}
	}
	
	public void pigAttakEnemy(Character character) {
		Pig pig = this.round.getPig();
		
		if (pig.isPowerful()) {
			Power power = pig.getPowerWithEnergy();
			power.setPosition(pig.getPosition());
			power.act(character);
		}
		
		if (character.isDied()) {
			if (character.getName().compareTo(Nutritionist.NAME) == 0) {
				cumulScore(ScoreConstantes.CHARACTER_NUTRITIONIST);
			} else if (character.getName().compareTo(Virus.NAME) == 0) {
				cumulScore(ScoreConstantes.CHARACTER_VIRUS);
			}
		}
	}
	
	public void enemyAttakPig(Character character) {
		if (character.isPowerful()) {
			Pig pig = (Pig) this.round.getPig();
			
			String powerName = null;
			if (character instanceof Nutritionist) {
				powerName = Diet.NAME;
			} else if (character instanceof Virus) {
				powerName = Disease.NAME;
			}
			
			Power power = character.getListPowers().get(powerName);
			power.act(pig);
			
			checkPigLife();
		}
	}
	
	public void pigEat(Food food) {
		Pig pig = this.round.getPig();
		
		if (pig.isGreedy()) {
			food.setEated(true);
			food.act(pig);
			
			if (food.getName().compareTo(Cake.NAME) == 0) {
				cumulScore(ScoreConstantes.FOOD_CAKE);
			}
		}
		
		checkEatenCake();
	}
	
	private void cumulScore(int scoreValue) {
		this.round.setScore(this.round.getScore() + scoreValue);
	}
	
	public void manageKeyCode(int keyCode) {
		if (keyCode == this.gamePad.getKeyStart()) {
			State state = this.round.getState();
			
			String title = "Round";
			String message = null;
			
			switch (state) {
				case STARTED :
					pause();
					
					message = "Paused";
					break;
				case PAUSED :
					resume();
					
					message = "Resumed";
					break;
				default :
					//TODO Throw exception
					break;
			}
			
			JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
		} else {
			Pig pig = this.round.getPig();
			
			if (keyCode == this.gamePad.getKeyMoveLeft()) {
				pig.move(Direction.LEFT);
			} else if (keyCode == this.gamePad.getKeyMoveRight()) {
				pig.move(Direction.RIGHT);
			} else if (keyCode == this.gamePad.getKeyMoveUp()) {
				pig.move(Direction.UP);
			} else if (keyCode == this.gamePad.getKeyMoveDown()) {
				pig.move(Direction.DOWN);
			} else if (keyCode == this.gamePad.getKeyPigAttak()) {
				//TODO
				
				Nutritionist nutritionist = new Nutritionist();
				pigAttakEnemy(nutritionist);
			} else {
				//TODO Throw exception
			}
			
			this.arenaView.repaint();
		}
	}
}
