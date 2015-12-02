package main.java.view.menu;

import javax.swing.JMenu;

public abstract class GameMenu extends JMenu {
	
	protected GameMenu(String name) {
		super(name);
		
		createMenuItems();
	}
	
	protected abstract void createMenuItems();
}