package main.java.view.menu;

import javax.swing.JMenu;

public abstract class GameMenu extends JMenu {
	
	protected GameMenu(String name, String command) {
		super(name);
		
		setActionCommand(command);
		createMenuItems();
	}
	
	protected abstract void createMenuItems();
}
