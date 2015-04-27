package game;

import game.round.ListRound;
import game.round.Round;
import game.round.RoundController;
import game.round.RoundManager;
import game.setting.ListSetting;
import game.setting.SettingManager;
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
	
	private void loadRounds() {
		ListRound listRound = RoundManager.loadAll();
		this.game.setListRound(listRound);
	}
	
	private void saveRounds() {
		ListRound listRound = this.game.getListRound();
		RoundManager.saveAll(listRound);
	}
	
	public void play() {
		showListRounds();
		
		this.gameView.pack();
		this.gameView.setVisible(true);
	}
	
	public void showListRounds() {
		loadRounds();
		
		this.gameView.displayListRoundView();
	}
	
	public void showLiveRound() {
		if (this.game.getLiveRound() != null) {
			this.gameView.displayLiveRoundView();
		}
	}
	
	private void configRound(Round round) {
		//ListSetting listSetting = SettingManager.loadAll();
		
		RoundView liveRoundView = new RoundView();
		RoundController roundController = new RoundController(round, liveRoundView);
		roundController.start();
		
		this.gameView.setLiveRoundView(liveRoundView);
		this.game.setLiveRound(round);
		this.game.getListRound().add(round);
	}
	
	public void newRound() {
		Round liveRound = new Round(1);
		configRound(liveRound);
		
		showLiveRound();
	}
	
	public void openRound(String roundId) {
		Round liveRound = this.game.getListRound().get(roundId);
		configRound(liveRound);
		
		showLiveRound();
	}
	
	public void exit() {
		saveRounds();
		
		this.gameView.dispose();
	}
}
