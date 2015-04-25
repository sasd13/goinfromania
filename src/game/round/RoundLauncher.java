package game.round;

import javax.swing.JOptionPane;

import game.Game;
import game.GameView;
import game.round.Round;
import game.round.RoundManager;
import game.round.RoundResult;
import game.setting.SettingManager;
import game.setting.SettingView;

public class RoundLauncher {

	public static void newRound() {
		GameView gameView = GameView.getInstance();
		
		Game game = Game.getInstance();
		Round liveRound = new Round();
		game.getListRound().add(liveRound);
		
		game.setLiveRound(liveRound);
		gameView.displayLiveRoundView();
	}
	
	public static void openRound(String roundId) {
		GameView gameView = GameView.getInstance();
		
		Game game = Game.getInstance();
		Round liveRound = game.getListRound().get(roundId);
		game.setLiveRound(liveRound);
		
		gameView.displayLiveRoundView();
	}
	
	public static void exitLiveRound(RoundResult roundResult) {
		GameView gameView = GameView.getInstance();
		
		Game game = Game.getInstance();
		Round liveRound = game.getLiveRound();
		game.setLiveRound(null);
		
		String title = null;
		String message = null;
		int selected;
		
		switch (roundResult) {
			case WIN :
				game.getListRound().remove(liveRound);
				
				title = "Result";
				message = "YOU WIN!!! Score : " + liveRound.getScore().getValue();
				
				JOptionPane.showMessageDialog(gameView, message, title, JOptionPane.OK_OPTION);
				gameView.displayListRoundView();
				break;
			case LOOSE :
				game.getListRound().remove(liveRound);
				
				title = "Result";
				message = "YOU LOOSE... New Round?";
				
				selected = JOptionPane.showConfirmDialog(gameView, message, title, JOptionPane.YES_NO_OPTION);
				switch (selected) {
					case JOptionPane.YES_OPTION :
						newRound();
						break;
					case JOptionPane.NO_OPTION :
						gameView.displayListRoundView();
						break;					
				}
				break;
			case PROGRESS :
				title = "Exit round";
				message = "Save your progress?";
				
				selected = JOptionPane.showConfirmDialog(gameView, message, title, JOptionPane.YES_NO_OPTION);
				switch (selected) {
					case JOptionPane.YES_OPTION :
						RoundManager.save(liveRound);
						break;					
				}
				gameView.displayListRoundView();
				break;
		}
	}
}
