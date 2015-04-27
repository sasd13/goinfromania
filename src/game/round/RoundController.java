package game.round;

import javax.swing.JOptionPane;

import game.Game;
import game.GameController;
import game.element.Element;
import game.element.ListElement;
import game.element.character.Character;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.Food;
import game.round.Round;
import game.round.RoundManager;
import game.round.Result;
import game.setting.Direction;
import game.setting.GamePad;
import game.view.GridView;
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
	
	public void start() {
		this.round.setState(State.STARTED);
		
		GridView gridView = this.roundView.getGridView();
		
		GamePadListener gamePadListener = new GamePadListener(this);
		gridView.getPanelDraw().addKeyListener(gamePadListener);
		gridView.getPanelDraw().setFocusable(true);
		gridView.getPanelDraw().requestFocusInWindow();
		
		GridListener listener = new GridListener(this);
		gridView.getButtonPigEatCake().addActionListener(listener);
		gridView.getButtonPigEatPoisonCake().addActionListener(listener);
		gridView.getButtonNutritionistAttak().addActionListener(listener);
		gridView.getButtonVirusAttak().addActionListener(listener);
	}
	
	public void resume() {
		this.round.setState(State.STARTED);
	}
	
	public void pause() {
		this.round.setState(State.PAUSED);
	}
	
	public void stop() {
		String title = null;
		String message = null;
		
		switch (this.round.getState()) {
			case STOPPED :
				title = "Exit round";
				message = "Save your progress?";
				
				int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
				switch (selected) {
					case JOptionPane.YES_OPTION :
						saveRound();
						break;					
				}
				break;
			case FINISHED :
				title = "Result";
				
				Pig pig = this.round.getPig();
				if (pig.isDied()) {
					this.round.setResult(Result.LOOSE);
					
					message = "YOU LOOSE... :-(";
					JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
				} else {
					this.round.setResult(Result.WIN);
					
					message = "YOU WIN :-)!!! Score : " + this.round.getScore();
					JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
				}
				break;
			default :
				break;
		}
		
		GameController.getInstance().closeRound(this.round);
	}
	
	public void saveRound() {
		if (this.round.getState() != State.FINISHED) {
			RoundManager.save(this.round);
		}
	}
	
	public void checkPigLife() {
		Pig pig = this.round.getPig();
		
		if (pig.isDied()) {
			this.round.setState(State.FINISHED);
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
			this.round.setState(State.FINISHED);
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
	
	public void pigAttak(Character character) {
		this.round.getPig().attak(character);
		
		if (character.isDied()) {
			if (character.getName().compareTo(Nutritionist.NAME) == 0) {
				cumulScore(ScoreConstantes.CHARACTER_NUTRITIONIST);
			} else if (character.getName().compareTo(Virus.NAME) == 0) {
				cumulScore(ScoreConstantes.CHARACTER_VIRUS);
			}
		}
	}
	
	public void enemyAttak(Character character) {
		character.attak(this.round.getPig());
		
		checkPigLife();
	}
	
	public void pigEat(Food food) {
		this.round.getPig().eat(food);
		
		if (food.getName().compareTo(Cake.NAME) == 0) {
			cumulScore(ScoreConstantes.FOOD_CAKE);
		}
		
		checkEatenCake();
	}
	
	private void cumulScore(int scoreValue) {
		this.round.setScore(this.round.getScore() + scoreValue);
	}
	
	public void manageKeyCode(int keyCode) {
		GamePad gamePad = Game.getInstance().getGamePad();
		
		if (keyCode == gamePad.getKeyStart()) {
			State state = this.round.getState();
			
			switch (state) {
				case STARTED :
					pause();
					break;
				case PAUSED :
					resume();
					break;
				default :
					break;
			}
		} else {
			Pig pig = this.round.getPig();
			
			if (keyCode == gamePad.getKeyMoveLeft()) {
				pig.move(Direction.LEFT);
			} else if (keyCode == gamePad.getKeyMoveRight()) {
				pig.move(Direction.RIGHT);
			} else if (keyCode == gamePad.getKeyMoveUp()) {
				pig.move(Direction.UP);
			} else if (keyCode == gamePad.getKeyMoveDown()) {
				pig.move(Direction.DOWN);
			} else if (keyCode == gamePad.getKeyPigAttak()) {
				//TODO
				
				Nutritionist nutritionist = new Nutritionist();
				pigAttak(nutritionist);
			}
		}
	}
}
