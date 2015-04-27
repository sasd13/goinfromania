package game;

import game.round.ListRound;
import game.round.Round;
import game.round.RoundController;
import game.round.RoundManager;
import game.round.State;
import game.view.GameView;
import game.view.RoundView;

public class GameController {

	private static GameController instance = null;
	
	private Game game;
	private GameView gameView;
	
	private GameController() {
		this.game = Game.getInstance();
		this.gameView = GameView.getInstance();
		
		this.game.addObserver(this.gameView);
	}
	
	public static synchronized GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		
		return instance;
	}
	
	public void play() {
		showListRounds();
		
		this.gameView.pack();
		this.gameView.setVisible(true);
	}
	
	public void newRound() {
		Round round = new Round(1);
		RoundController roundController = configRound(round);
		
		this.gameView.displayLiveRoundView();
		roundController.start();
	}
	
	public void openRound(String roundId) {
		Round round = this.game.getListRound().get(roundId);
		RoundController roundController = configRound(round);
		
		this.gameView.displayLiveRoundView();
		roundController.start();
	}
	
	public void closeRound(Round round) {
		if (round.getState() == State.FINISHED) {
			this.game.getListRound().remove(round);
		}
		
		saveRounds();
		
		showListRounds();
	}
	
	public void exit() {
		saveRounds();
		
		this.gameView.dispose();
	}
	
	private void loadRounds() {
		ListRound listRound = RoundManager.loadAll();
		this.game.setListRound(listRound);
	}
	
	private void saveRounds() {
		ListRound listRound = this.game.getListRound();
		RoundManager.saveAll(listRound);
	}
	
	public void showListRounds() {
		loadRounds();
		
		this.gameView.displayListRoundView();
	}
	
	private RoundController configRound(Round round) {
		RoundController roundController = null;
		
		//ListSetting listSetting = SettingManager.loadAll();
		
		this.game.getListRound().add(round);
		
		RoundView roundView = new RoundView();		
		roundController = new RoundController(round, roundView);
		
		this.gameView.setLiveRoundView(roundView);
		
		return roundController;
	}
}
