package game.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.GameController;

public class MenuFile extends JMenu implements ActionListener {

	public static final String NAME = "File";
	
	private final String ITEM_NEW = "New round";
	private final String ITEM_OPEN = "Open round";
	private final String ITEM_SCORES = "Show scores";
	private final String ITEM_EXIT = "Exit";
	
	public MenuFile() {
		super(NAME);
		
		JMenuItem itemNew = new JMenuItem(ITEM_NEW);
		itemNew.addActionListener(this);
		add(itemNew);
		
		JMenuItem itemOpen = new JMenuItem(ITEM_OPEN);
		itemOpen.addActionListener(this);
		add(itemOpen);
		
		addSeparator();
		
		JMenuItem itemScores = new JMenuItem(ITEM_SCORES);
		itemScores.addActionListener(this);
		add(itemScores);
		
		addSeparator();
		
		JMenuItem itemExit = new JMenuItem(ITEM_EXIT);
		itemExit.addActionListener(this);
		add(itemExit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		GameController gameController = GameController.getInstance();
		
		if (item.getText().compareTo(ITEM_NEW) == 0) {
			gameController.closeRoundIfInProgress();
			gameController.newRound();
		} else if (item.getText().compareTo(ITEM_OPEN) == 0) {
			gameController.closeRoundIfInProgress();
			GameController.getInstance().displayListRounds();
		} else if (item.getText().compareTo(ITEM_SCORES) == 0) {
			GameController.getInstance().displayListScores();
		} else if (item.getText().compareTo(ITEM_EXIT) == 0) {
			gameController.closeRoundIfInProgress();
			GameController.getInstance().exitGame();
		} else {
			//TODO Throw exception
		}
	}
}
