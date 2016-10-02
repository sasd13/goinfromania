package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.bean.setting.SettingFactory;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class CreateStateProcessor implements IStateProcessor {

	private IFrame frame;
	private StartStateProcessor next;

	public CreateStateProcessor(IFrame frame) {
		this.frame = frame;
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.CREATED.getOrder()) {
			createGame(game);
		}

		if (stateTarget > EnumState.CREATED.getOrder()) {
			if (next == null) {
				next = new StartStateProcessor(frame);
			}

			next.process(stateTarget, game);
		}
	}

	private void createGame(Game game) {
		frame.displayGame(game);
		game.setState(EnumState.CREATED);
		game.addElement(new Pig());
		
		setGamepad();
		//frame.displayGame(game);
	}
	
	private void setGamepad() {
		Gamepad gamepad = (Gamepad) SettingPreferencesFactory.make(EnumSetting.GAMEPAD.getCode()).pull();
		
		frame.getGameView().setGamepad(gamepad);
	}
}
