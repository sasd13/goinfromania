package main.java.view.dialog;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JFrame;

import main.java.view.GameView;

public abstract class GameDialog extends JDialog implements Observer {
	
	protected GameView gameView;
	
	protected GameDialog(GameView gameView) {
		super();
		
		this.gameView = gameView;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setUndecorated(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//Do nothing
	}
}