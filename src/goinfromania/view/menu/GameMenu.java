package goinfromania.view.menu;

import goinfromania.controller.MenuController;

import javax.swing.JMenu;

public abstract class GameMenu extends JMenu {
	
	protected MenuController menuController;

	protected GameMenu(String name, MenuController menuController) {
		super(name);
		
		this.menuController = menuController;
		
		prepareMenu();
		addMenuItems();
	}
	
	protected abstract void prepareMenu();
	
	protected abstract void addMenuItems();
}
