package com.sasd13.goinfromania.controller.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.GameHandler;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuSettingsController implements ActionListener {

	private IFrameView frameView;
	private MenuSettingsActionFactory factory;
	private Game game;

	public MenuSettingsController(IFrameView frameView) {
		this.frameView = frameView;
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
		
		factory.make(event.getActionCommand()).execute(frameView);
	}
}
