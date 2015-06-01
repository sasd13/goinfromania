package view.menu;

import javax.swing.JMenuBar;

public class GameMenuBar extends JMenuBar {

	private MenuFile menuFile;
	private MenuRound menuRound;
	private MenuSetting menuSetting;
	private MenuHelp menuHelp;
	
	public GameMenuBar() {
		super();
		
		this.menuFile = new MenuFile();
		add(this.menuFile);
		
		this.menuRound = new MenuRound();
		this.menuRound.setEnabled(false);
		add(this.menuRound);
		
		this.menuSetting = new MenuSetting();
		add(this.menuSetting);
		
		this.menuHelp = new MenuHelp();
		add(this.menuHelp);
	}
	
	public void setMenuRoundEnabled(boolean enabled) {
		this.menuRound.setEnabled(enabled);
	}
}
