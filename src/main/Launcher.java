package main;

import game.Game;
import game.GameView;
import game.round.ListRound;
import game.round.ListRoundView;
import game.round.Round;
import game.round.RoundManager;
import game.round.RoundResult;
import game.round.RoundView;
import game.setting.MapSetting;
import game.setting.SettingManager;
import game.setting.SettingType;

public class Launcher {

	public static void launchGame() {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		game.addObserver(gameView);
		
		MapSetting mapSetting = SettingManager.loadAll();
		game.setMapSetting(mapSetting);
		
		ListRound listRound = RoundManager.loadAll();
		game.setListRound(listRound);
		
		gameView.update(game, null);
		gameView.display();
	}
	
	public static void exitGame() {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		game.deleteObserver(gameView);
		
		ListRound listRound = game.getListRound();
		for(int i=0; i<listRound.size(); i++) {
			RoundManager.save(listRound.get(i));
		}
		
		MapSetting  mapSetting = game.getMapSetting();
		for(SettingType settingType : SettingType.values()) {
			SettingManager.save(mapSetting.get(settingType));
		}
		
		gameView.mask();
	}
	
	public static void showListRound() {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		ListRound listRound = game.getListRound();
		ListRoundView listRoundView = gameView.getListRoundView();
		
		listRound.addObserver(listRoundView);
		
		listRoundView.update(listRound, null);
		listRoundView.display();		
	}
	
	public static void hideListRound() {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		ListRound listRound = game.getListRound();
		ListRoundView listRoundView = gameView.getListRoundView();
		
		listRound.deleteObserver(listRoundView);
		
		listRoundView.mask();
	}
	
	public static void launchLiveRound(Round round) {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		RoundView liveRoundView = gameView.getRoundView();
		
		round.addObserver(liveRoundView);
		
		game.setLiveRound(round);
		
		liveRoundView.update(round, null);
		liveRoundView.display();
	}
	
	public static void exitLiveRound() {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		Round liveRound = game.getLiveRound();
		RoundView liveRoundView = gameView.getRoundView();
		
		liveRound.deleteObserver(liveRoundView);
		
		RoundResult result = liveRound.stop();
		switch (result) {
			case WIN :
				break;
			case LOOSE :
				break;
			case PROGRESS :
				RoundManager.save(liveRound);
				break;
		}
		
		liveRoundView.mask();
	}
}
