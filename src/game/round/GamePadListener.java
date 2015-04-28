package game.round;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.RoundController;

public class GamePadListener implements KeyListener {

	private RoundController roundController;
	
	public GamePadListener(RoundController roundController) {
		this.roundController = roundController;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		this.roundController.manageKeyCode(arg0.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		this.roundController.manageKeyCode(arg0.getKeyCode());
	}
}
