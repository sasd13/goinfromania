package game.menu;

import javax.swing.JMenuBar;

public class GameMenu extends JMenuBar {

	public GameMenu() {
		super();
		
		add(new MenuFile());
		add(new MenuSetting());
	}
}
