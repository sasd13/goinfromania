package goinfromania.view.menu;

import goinfromania.controller.MenuFileController;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuFile extends GameMenu {

	public MenuFile() {
		super("Fichier", new MenuFileController());
	}
	
	@Override
	protected void prepareMenu() {
		setMnemonic(KeyEvent.VK_F);
	}
	
	@Override
	protected void addMenuItems() {
		JMenuItem[] menuItems = {
				new JMenuItem("Nouveau"),
				new JMenuItem("Ouvrir..."),
				new JMenuItem("Quitter")
		};
		
		String command = null;
		KeyStroke keyStroke = null;
		
		int indice = 0;
		for (JMenuItem menuItem : menuItems) {
			indice++;
			
			switch (indice) {
				case 0:
					command = "NEW";
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK);
					break;
				case 1:
					command = "OPEN";
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK);
					break;
				case 2:
					addSeparator();
					
					command = "EXIT";
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK);
					break;
			}
			menuItem.setActionCommand(command);
			menuItem.setAccelerator(keyStroke);
			menuItem.addActionListener(this.menuController);
			
			add(menuItem);
		}
	}
}
