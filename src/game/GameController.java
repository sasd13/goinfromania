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
	
	private void update() {
		this.gameView.update(this.game, null);
	}
	
	private void loadSettings() {
		ListSetting listSetting = SettingManager.loadAll();
		this.game.setMapSetting(listSetting);
	}
	
	private void loadRounds() {
		ListRound listRound = RoundManager.loadAll();
		this.game.setListRound(listRound);
	}
	
	private void saveSettings() {
		ListSetting listSetting = this.game.getMapSetting();
		SettingManager.saveAll(listSetting);
	}
	
	private void saveRounds() {
		ListRound listRound = this.game.getListRound();
		RoundManager.saveAll(listRound);
	}
	
	public void play() {
		loadSettings();
		loadRounds();
		
		this.gameView.pack();
		this.gameView.setVisible(true);
		
		update();
	}
	
	public void showListRounds() {
		loadRounds();
		
		this.gameView.displayListRoundView();
		update();
	}
	
	public void showLiveRound() {
		if (this.game.getLiveRound() != null) {
			this.gameView.displayLiveRoundView();
			update();
		}
	}
	
	public void newRound() {
		Round liveRound = new Round(1);
		RoundView liveRoundView = this.gameView.getLiveRoundView();
		RoundController roundController = new RoundController(liveRound, liveRoundView);
		roundController.start();
		
		this.game.getListRound().add(liveRound);
		this.game.setLiveRound(liveRound);
		
		showLiveRound();
	}
	
	public void openRound(String roundId) {
		Round liveRound = this.game.getListRound().get(roundId);
		RoundView liveRoundView = this.gameView.getLiveRoundView();
		RoundController roundController = new RoundController(liveRound, liveRoundView);
		
		this.game.setLiveRound(liveRound);
		
		showLiveRound();
		
		roundController.start();
	}
	
	public void exit() {
		saveRounds();
		saveSettings();
		
		this.gameView.dispose();
	}
}
