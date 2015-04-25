package game;

import game.round.ListRound;
import game.round.RoundManager;
import game.setting.MapSetting;
import game.setting.SettingManager;

public class GameLauncher {

	public static void play() {
		GameView gameView = GameView.getInstance();
		
		Game game = Game.getInstance();
		game.addObserver(gameView);
		
		MapSetting mapSetting = SettingManager.loadAll();
		game.setMapSetting(mapSetting);
		
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
		
		MapSetting  mapSetting = game.getMapSetting();
		SettingManager.saveAll(mapSetting);
		
		gameView.dispose();
	}
}
