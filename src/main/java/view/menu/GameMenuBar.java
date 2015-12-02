package main.java.view.menu;

import javax.swing.JMenuBar;

public class GameMenuBar extends JMenuBar {
	
	private MenuEdit menuEdit;

	public GameMenuBar() {
		super();
		
		this.menuEdit = new MenuEdit();
		
		GameMenu[] gameMenus = {
				new MenuFile(),
				this.menuEdit,
				new MenuSetting()
		};
		
		for (GameMenu gameMenu : gameMenus) {
			add(gameMenu);
		}
	}
	
	public void setMenuEditEnabled(boolean enabled) {
		this.menuEdit.setEnabled(enabled);
	}
}
