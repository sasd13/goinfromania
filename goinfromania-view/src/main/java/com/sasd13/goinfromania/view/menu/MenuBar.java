package com.sasd13.goinfromania.view.menu;

import javax.swing.JMenuBar;

import com.sasd13.goinfromania.controller.IFrame;

public class MenuBar extends JMenuBar {

	private MenuEdit menuEdit;

	public MenuBar(IFrame frame) {
		super();

		menuEdit = new MenuEdit(frame);

		add(new MenuFile(frame));
		add(menuEdit);
		add(new MenuSettings(frame));
	}

	public void setMenuEditEnabled(boolean enabled) {
		menuEdit.setEnabled(enabled);
	}
}
