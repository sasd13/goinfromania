package game.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuRound extends JMenu implements ActionListener {

	private final String ITEM_PAUSE = "Pause";
	private final String ITEM_RESTART = "Restart";
	private final String ITEM_STOP = "Stop";
	private final String ITEM_SAVE = "Save";
	
	public MenuRound() {
		super("Round");
		
		JMenuItem itemPause = new JMenuItem(ITEM_PAUSE);
		itemPause.addActionListener(this);
		add(itemPause);
		
		JMenuItem itemRestart = new JMenuItem(ITEM_RESTART);
		itemRestart.addActionListener(this);
		add(itemRestart);
		
		JMenuItem itemStop = new JMenuItem(ITEM_STOP);
		itemStop.addActionListener(this);
		add(itemStop);
		
		addSeparator();
		
		JMenuItem itemSave = new JMenuItem(ITEM_SAVE);
		itemSave.addActionListener(this);
		add(itemSave);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		if (item.getText().compareTo(ITEM_PAUSE) == 0) {
			
		} else if (item.getText().compareTo(ITEM_RESTART) == 0) {
			
		} else if (item.getText().compareTo(ITEM_STOP) == 0) {
			
		} else if (item.getText().compareTo(ITEM_SAVE) == 0) {
			
		} else {
			//TODO Throw exception
		}
	}
}
