package com.sasd13.goinfromania.view.menu;

import javax.swing.JMenuBar;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuBar extends JMenuBar {

	private MenuFile menuFile;
	private MenuEdit menuEdit;
	private MenuSettings menuSettings;

	public MenuBar(IFrameView frameView) {
		super();

		menuFile = new MenuFile(frameView);
		menuEdit = new MenuEdit(frameView);
		menuSettings = new MenuSettings(frameView);

		buildView();
	}

	private void buildView() {
		add(menuFile);
		add(menuEdit);
		add(menuSettings);
	}

	public void setMenuEditEnabled(boolean enabled) {
		menuEdit.setEnabled(enabled);
	}

	public void setGame(Game game) {
		menuFile.setGame(game);
		menuEdit.setGame(game);
	}

	public void setGamepad(Gamepad gamepad) {
		menuSettings.setGamepad(gamepad);
	}
}
