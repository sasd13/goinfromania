package game;

import game.round.ListRound;
import game.round.RoundManager;
import game.setting.MapSetting;
import game.setting.SettingManager;

public class GameLauncher {

	public static void play() {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		game.addObserver(gameView);
		
		MapSetting mapSetting = SettingManager.loadAll();
		game.setMapSetting(mapSetting);
		
		ListRound listRound = RoundManager.loadAll();
		game.setListRound(listRound);
		
		gameView.pack();
		gameView.setVisible(true);
	}
	
	public static void exit() {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		game.deleteObserver(gameView);
		
		ListRound listRound = game.getListRound();
		RoundManager.saveAll(listRound);
		
		MapSetting  mapSetting = game.getMapSetting();
		SettingManager.saveAll(mapSetting);
		
		gameView.dispose();
	}
}
