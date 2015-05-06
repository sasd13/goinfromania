package game.round.arena;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.GameController;
import controller.RoundController;

public class GamePadListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		RoundController roundController = GameController.getInstance().getRoundController();
		roundController.actionGamePad(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		RoundController roundController = GameController.getInstance().getRoundController();
		roundController.actionGamePad(e.getKeyCode());
	}

}
