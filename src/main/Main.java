package main;

import game.Game;
import game.GameView;
import game.WindowController;

public class Main {

	public static void main(String[] args) {
		Game game = Game.getInstance();
		GameView gameView = new GameView();
		WindowController controller = new WindowController(game, gameView);
		gameView.addWindowListener(controller);
		gameView.display();
	}
}
