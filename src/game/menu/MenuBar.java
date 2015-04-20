package game.menu;

import game.Game;
import game.GameView;
import game.setting.SettingType;
import game.setting.SettingViewFactory;
import game.setting.KeyboardSettingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	public MenuBar() {
		super();
		
		JMenu menuFile = new JMenu("File");
		JMenuItem itemNew = new JMenuItem("New round");
		menuFile.add(itemNew);
		JMenuItem itemExit = new JMenuItem("Exit");
		menuFile.add(itemExit);
		itemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.getInstance().exit();
				GameView.getInstance().dispose();
			}
		});
		add(menuFile);
		
		JMenu menuSettings = new JMenu("Settings");
		JMenuItem itemKeyBoard = new JMenuItem("KeyBoard controller");
		itemKeyBoard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				KeyboardSettingView keyboardSettingView = (KeyboardSettingView) SettingViewFactory.create(SettingType.KEYBOARD);
				keyboardSettingView.display();
			}
		});
		menuSettings.add(itemKeyBoard);
		add(menuSettings);
	}
}
