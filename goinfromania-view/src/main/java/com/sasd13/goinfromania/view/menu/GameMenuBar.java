package com.sasd13.goinfromania.view.menu;

import javax.swing.JMenuBar;

public class GameMenuBar extends JMenuBar {
	
	private MenuEdit menuEdit;

	public GameMenuBar() {
		super();
		
		menuEdit = new MenuEdit();
		
		GameMenu[] gameMenus = {
				new MenuFile(),
				menuEdit,
				new MenuSetting()
		};
		
		for (GameMenu gameMenu : gameMenus) {
			add(gameMenu);
		}
	}
	
	public void setMenuEditEnabled(boolean enabled) {
		menuEdit.setEnabled(enabled);
	}
}
