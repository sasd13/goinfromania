package com.sasd13.goinfromania.view.menu;

import javax.swing.JMenuBar;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class MenuBar extends JMenuBar {

	private MenuFile menuFile;
	private MenuEdit menuEdit;

	public MenuBar(IFrame frame) {
		super();

		menuFile = new MenuFile(frame);
		menuEdit = new MenuEdit(frame);

		add(menuFile);
		add(menuEdit);
		add(new MenuSettings(frame));
	}

	public void setGame(Game game) {
		menuFile.setGame(game);
		menuEdit.setGame(game);
	}

	public void setMenuEditEnabled(boolean enabled) {
		menuEdit.setEnabled(enabled);
	}
}
