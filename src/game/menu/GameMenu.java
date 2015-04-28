package game.menu;

import javax.swing.JMenuBar;

public class GameMenu extends JMenuBar {

	private MenuFile menuFile;
	private MenuRound menuRound;
	private MenuSetting menuSetting;
	
	public GameMenu() {
		super();
		
		this.menuFile = new MenuFile();
		add(this.menuFile);
		
		this.menuRound = new MenuRound();
		this.menuRound.setEnabled(false);
		add(this.menuRound);
		
		this.menuSetting = new MenuSetting();
		add(this.menuSetting);
	}
	
	public MenuFile getMenuFile() {
		return this.menuFile;
	}
	
	public MenuRound getMenuRound() {
		return this.menuRound;
	}
	
	public MenuSetting getMenuSetting() {
		return this.menuSetting;
	}
}
