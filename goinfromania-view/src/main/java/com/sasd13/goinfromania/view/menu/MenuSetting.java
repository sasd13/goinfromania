package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.controller.menu.settings.MenuSettingsController;

public class MenuSetting extends GameMenu {

	public MenuSetting() {
		super("Options");
		
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
			menuItem.addActionListener(new MenuSettingsController());
			
			add(menuItem);
		}
	}
}
