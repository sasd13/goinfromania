package com.sasd13.goinfromania.view.menu;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	private MenuEdit menuEdit;

	public MenuBar() {
		super();

		menuEdit = new MenuEdit();

		add(new MenuFile());
		add(menuEdit);
		add(new MenuSettings());
	}

	public void setMenuEditEnabled(boolean enabled) {
		menuEdit.setEnabled(enabled);
	}
}
