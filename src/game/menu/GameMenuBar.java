package game.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class GameMenuBar extends JMenuBar {

	private MenuFile menuFile;
	private MenuRound menuRound;
	private MenuSettings menuSettings;
	
	public GameMenuBar() {
		super();
		
		this.menuFile = new MenuFile();
		add(this.menuFile);
		
		this.menuRound = new MenuRound();
		this.menuRound.setEnabled(false);
		add(this.menuRound);
		
		this.menuSettings = new MenuSettings();
		add(this.menuSettings);
	}
	
	public JMenu getMenu(String menuName) {
		switch (menuName) {
			case MenuFile.NAME:
				return this.menuFile;
			case MenuRound.NAME:
				return this.menuRound;
			case MenuSettings.NAME:
				return this.menuSettings;
			default :
				//TODO Throw exception
				return null;
		}
	}
}
