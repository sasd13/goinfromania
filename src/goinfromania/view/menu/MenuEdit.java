package goinfromania.view.menu;

import goinfromania.controller.MenuEditController;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuEdit extends GameMenu {
	
	public MenuEdit() {
		super("Parie", new MenuEditController());
	}
	
	@Override
	protected void prepareMenu() {
		setMnemonic(KeyEvent.VK_P);
	}

	@Override
	protected void addMenuItems() {
		JMenuItem[] menuItems = {
				new JMenuItem("Pause"),
				new JMenuItem("Stop"),
				new JMenuItem("Sauvegarder")
		};
		
		KeyStroke keyStroke = null;
		
		int indice = 0;
		for (JMenuItem menuItem : menuItems) {
			indice++;
			
			switch (indice) {
				case 0:
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK);
					break;
				case 1:
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK);
					break;
				case 2:
					addSeparator();
					
					keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
					break;
			}
			menuItem.addActionListener(this.menuController);
			menuItem.setAccelerator(keyStroke);
			
			add(menuItem);
		}
	}
}
