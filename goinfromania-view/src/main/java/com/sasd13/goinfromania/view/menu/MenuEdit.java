package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.controller.menu.edit.MenuEditController;

public class MenuEdit extends GameMenu {
	
	public MenuEdit() {
		super("Partie");
		
		setMnemonic(KeyEvent.VK_P);
	}

	@Override
	protected void createMenuItems() {
		JMenuItem[] menuItems = {
				new JMenuItem("Pause / Reprise"),
				new JMenuItem("Stop"),
				new JMenuItem("Sauvegarder")
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
					command = "PAUSE";
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK);
					break;
				case 1:
					command = "STOP";
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK);
					break;
				case 2:
					addSeparator();
					
					command = "SAVE";
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
					break;
			}
			menuItem.setActionCommand(command);
			menuItem.setAccelerator(keyStroke);
			menuItem.addActionListener(new MenuEditController());
			
			add(menuItem);
		}
	}
}
