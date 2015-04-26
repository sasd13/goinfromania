package game;

import game.round.ListRound;
import game.round.RoundManager;
import game.setting.ListSetting;
import game.setting.SettingManager;

public class GameLauncher {

	public static void play() {
		GameView gameView = GameView.getInstance();
		
		Game game = Game.getInstance();
		game.addObserver(gameView);
		
		ListSetting listSetting = SettingManager.loadAll();
		game.setMapSetting(listSetting);
		
		ListRound listRound = RoundManager.loadAll();
		game.setListRound(listRound);
		
		gameView.pack();
		gameView.setVisible(true);
	}
	
	public static void exit() {
		GameView gameView = GameView.getInstance();
		
		Game game = Game.getInstance();
		
		ListRound listRound = game.getListRound();
		RoundManager.saveAll(listRound);
		
		ListSetting listSetting = game.getMapSetting();
		SettingManager.saveAll(listSetting);
		
		gameView.dispose();
	}
}
