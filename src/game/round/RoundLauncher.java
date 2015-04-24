package game.round;

import game.Game;
import game.GameView;
import game.round.Round;
import game.round.RoundManager;
import game.round.RoundResult;

public class RoundLauncher {

	public static void launchLiveRound(String roundId) {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		Round liveRound = game.getListRound().get(roundId);
		game.setLiveRound(liveRound);
		
		gameView.displayLiveRoundView();
	}
	
	public static void exitLiveRound() {
		Game game = Game.getInstance();
		GameView gameView = GameView.getInstance();
		
		Round liveRound = game.getLiveRound();
		
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
		
		game.setLiveRound(null);
		
		gameView.displayListRoundView();
	}
}
