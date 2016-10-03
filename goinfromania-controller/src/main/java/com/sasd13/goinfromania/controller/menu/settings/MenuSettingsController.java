package com.sasd13.goinfromania.controller.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.engine.GameHandler;

public class MenuSettingsController implements ActionListener {

	private IFrame frame;
	private MenuSettingsActionFactory factory;
	private Game game;

	public MenuSettingsController(IFrame frame) {
		this.frame = frame;
		factory = new MenuSettingsActionFactory();
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setGamepad(Gamepad gamepad) {
		factory.setGamepad(gamepad);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (game != null && game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			GameHandler.pauseGame(game);
		}
		
		factory.make(event.getActionCommand()).execute(frame);
	}
}
