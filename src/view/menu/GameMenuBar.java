package view.menu;

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
	
	public void setMenuRoundEnabled(boolean enabled) {
		this.menuRound.setEnabled(enabled);
	}
}
