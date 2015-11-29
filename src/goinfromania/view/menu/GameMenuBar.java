package goinfromania.view.menu;

import javax.swing.JMenuBar;

public class GameMenuBar extends JMenuBar {

	private MenuFile menuFile;
	private MenuEdit menuEdit;
	private MenuSetting menuSetting;
	
	public GameMenuBar() {
		super();
		
		this.menuFile = new MenuFile();
		add(this.menuFile);
		
		this.menuEdit = new MenuEdit();
		this.menuEdit.setEnabled(false);
		add(this.menuEdit);
		
		this.menuSetting = new MenuSetting();
		add(this.menuSetting);
	}
	
	public void setMenuEditEnabled(boolean enabled) {
		this.menuEdit.setEnabled(enabled);
	}
}
