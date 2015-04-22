package game.menu;

import game.setting.SettingType;
import game.setting.SettingViewFactory;
import game.setting.GamePadView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import main.Launcher;

public class GameMenu extends JMenuBar {

	public GameMenu() {
		super();
		
		JMenu menuFile = new JMenu("File");
		JMenuItem itemNew = new JMenuItem("New round");
		menuFile.add(itemNew);
		JMenuItem itemOpen = new JMenuItem("Open round");
		menuFile.add(itemOpen);
		JMenuItem itemExit = new JMenuItem("Exit");
		menuFile.add(itemExit);
		itemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Launcher.exitGame();
			}
		});
		add(menuFile);
		
		JMenu menuSettings = new JMenu("Settings");
		JMenuItem itemKeyBoard = new JMenuItem("KeyBoard controller");
		itemKeyBoard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GamePadView gamePadView = (GamePadView) SettingViewFactory.create(SettingType.GAMEPAD);
				gamePadView.display();
			}
		});
		menuSettings.add(itemKeyBoard);
		add(menuSettings);
	}
}
