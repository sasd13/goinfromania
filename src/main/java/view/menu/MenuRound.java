package main.java.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import main.java.controller.RoundController;

public class MenuRound extends JMenu implements ActionListener {

	public static final String NAME = "Partie";
	
	private final String ITEM_STOP = "Stopper";
	private final String ITEM_SAVE = "Sauvegarder";
	
	public MenuRound() {
		super(NAME);
		
		setMnemonic(KeyEvent.VK_P);
		
		JMenuItem itemStop = new JMenuItem(ITEM_STOP);
		itemStop.addActionListener(this);
		itemStop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		add(itemStop);
		
		addSeparator();
		
		addSeparator();
		
		JMenuItem itemSave = new JMenuItem(ITEM_SAVE);
		itemSave.addActionListener(this);
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		add(itemSave);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		if (item.getText().compareTo(ITEM_STOP) == 0) {
			RoundController.showDialogConfirmStopRound();
		} else if (item.getText().compareTo(ITEM_SAVE) == 0) {
			RoundController.saveRound();
		}
	}
}
