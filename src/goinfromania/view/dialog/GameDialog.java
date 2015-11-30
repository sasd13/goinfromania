package goinfromania.view.dialog;

import java.util.Observable;
import java.util.Observer;

import goinfromania.view.frame.GameView;

import javax.swing.JDialog;
import javax.swing.JFrame;

public abstract class GameDialog extends JDialog implements Observer {
	
	protected GameView gameView;
	
	protected GameDialog(GameView gameView) {
		super();
		
		this.gameView = gameView;
		
		prepareDialog();
	}
	
	protected void prepareDialog() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setUndecorated(true);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		//Do nothing
	}
}
