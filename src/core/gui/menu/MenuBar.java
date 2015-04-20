package core.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import core.params.KeyboardParamsView;
import core.params.ParamsType;
import core.params.ParamsViewFactory;

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
		JMenuItem itemKeyBoard = new JMenuItem("KeyBoard controller");
		itemKeyBoard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				KeyboardParamsView keyboardParamsView = (KeyboardParamsView) ParamsViewFactory.create(ParamsType.KEYBOARD);
				keyboardParamsView.display();
			}
		});
		menuSettings.add(itemKeyBoard);
		add(menuSettings);
	}
}
