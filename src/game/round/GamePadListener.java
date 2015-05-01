package game.round;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.GameController;
import controller.RoundController;

public class GamePadListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		RoundController roundController = GameController.getInstance().getRoundController();
		roundController.actionGamePad(arg0.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		RoundController roundController = GameController.getInstance().getRoundController();
		roundController.actionGamePad(arg0.getKeyCode());
	}
}
