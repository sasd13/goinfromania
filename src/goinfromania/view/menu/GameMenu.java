package goinfromania.view.menu;

import javax.swing.JMenu;

public abstract class GameMenu extends JMenu {
	
	protected GameMenu(String name, String command) {
		super(name);
		
		setActionCommand(command);
		prepareMenu();
		addMenuItems();
	}
	
	protected abstract void prepareMenu();
	
	protected abstract void addMenuItems();
}
