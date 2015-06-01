package view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.GameController;

public class MenuFile extends JMenu implements ActionListener {

	public static final String NAME = "Fichier";
	
	private final String ITEM_NEW = "Nouvelle partie";
	private final String ITEM_OPEN = "Ovrir une partie...";
	private final String ITEM_SCORES = "Afficher les scores";
	private final String ITEM_EXIT = "Quitter";
	
	public MenuFile() {
		super(NAME);
		
		setMnemonic(KeyEvent.VK_F);
		
		JMenuItem itemNew = new JMenuItem(ITEM_NEW);
		itemNew.addActionListener(this);
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		add(itemNew);
		
		JMenuItem itemOpen = new JMenuItem(ITEM_OPEN);
		itemOpen.addActionListener(this);
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		add(itemOpen);
		
		addSeparator();
		
		JMenuItem itemScores = new JMenuItem(ITEM_SCORES);
		itemScores.addActionListener(this);
		itemScores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		add(itemScores);
		
		addSeparator();
		
		JMenuItem itemExit = new JMenuItem(ITEM_EXIT);
		itemExit.addActionListener(this);
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		add(itemExit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		boolean stopped = GameController.stopRoundIfStarted();
		
		if (stopped) {
			if (item.getText().compareTo(ITEM_NEW) == 0) {
				GameController.newRound();
			} else if (item.getText().compareTo(ITEM_OPEN) == 0) {
				GameController.displayListRounds();
			} else if (item.getText().compareTo(ITEM_SCORES) == 0) {
				GameController.displayListScores();
			} else if (item.getText().compareTo(ITEM_EXIT) == 0) {
				GameController.showDialogConfirmExitGame();
			}
		}
	}
}
