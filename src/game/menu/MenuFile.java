package game.menu;

import game.Game;
import game.GameController;
import game.round.Round;
import game.round.RoundManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuFile extends JMenu implements ActionListener {

	private final String ITEM_NEW = "New round";
	private final String ITEM_OPEN = "Open round";
	private final String ITEM_SAVE = "Save";
	private final String ITEM_SCORES = "Show scores";
	private final String ITEM_EXIT = "Exit";
	
	public MenuFile() {
		super("File");
		
		JMenuItem itemNew = new JMenuItem(ITEM_NEW);
		itemNew.addActionListener(this);
		add(itemNew);
		
		JMenuItem itemOpen = new JMenuItem(ITEM_OPEN);
		itemOpen.addActionListener(this);
		add(itemOpen);
		
		addSeparator();
		
		JMenuItem itemSave = new JMenuItem(ITEM_SAVE);
		itemSave.addActionListener(this);
		add(itemSave);
		
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
		
		if (item.getText().compareTo(ITEM_NEW) == 0) {
			GameController.getInstance().newRound();
		} else if (item.getText().compareTo(ITEM_OPEN) == 0) {
			GameController.getInstance().openRound(null);
		} else if (item.getText().compareTo(ITEM_SAVE) == 0) {
			Round round = Game.getInstance().getLiveRound();
			if (round != null && !round.isFinished()) {
				RoundManager.save(round);
			}
		} else if (item.getText().compareTo(ITEM_SCORES) == 0) {
			
		} else if (item.getText().compareTo(ITEM_EXIT) == 0) {
			GameController.getInstance().exit();
		} else {
			//Throw exception
		}
	}
}
