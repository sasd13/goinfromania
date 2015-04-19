package core.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import core.params.KeyboardParams;

public class MenuBar extends JMenuBar {

	public MenuBar() {
		super();
		
		JMenu menuFile = new JMenu("File");
		JMenuItem itemNew = new JMenuItem("New round");
		menuFile.add(itemNew);
		JMenuItem itemExit = new JMenuItem("Exit");
		menuFile.add(itemExit);
		add(menuFile);
		
		JMenu menuSettings = new JMenu("Settings");
		JMenuItem itemKeyBoard = new JMenuItem("KeyBoard...");
		itemKeyBoard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				KeyboardParams keyboardParameters = new KeyboardParams();
				keyboardParameters.show();
			}
		});
		menuSettings.add(itemKeyBoard);
		add(menuSettings);
	}
}
