package goinfromania.view.menu;

import goinfromania.controller.menu.MenuSettingController;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuSetting extends GameMenu {

	public MenuSetting() {
		super("Options", "MENUSETTING");
		
		setMnemonic(KeyEvent.VK_O);
	}
	
	@Override
	protected void createMenuItems() {
		JMenuItem[] menuItems = {
				new JMenuItem("Clavier")
		};
		
		addMenuItemsToMenu(menuItems);
	}

	private void addMenuItemsToMenu(JMenuItem[] menuItems) {
		String command = null;
		KeyStroke keyStroke = null;
		
		int indice = -1;
		for (JMenuItem menuItem : menuItems) {
			indice++;
			
			switch (indice) {
				case 0:
					command = "GAMEPAD";
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK);
					break;
			}
			menuItem.setActionCommand(command);
			menuItem.setAccelerator(keyStroke);
			menuItem.addActionListener(new MenuSettingController());
			
			add(menuItem);
		}
	}
}
