package goinfromania.view.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;

public abstract class GameDialog extends JDialog {
	
	protected GameDialog() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setUndecorated(true);
	}
}
