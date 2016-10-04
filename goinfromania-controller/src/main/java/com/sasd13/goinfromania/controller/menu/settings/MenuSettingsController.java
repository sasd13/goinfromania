package com.sasd13.goinfromania.controller.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuSettingsController implements ActionListener {

	private IFrameView frameView;
	private MenuSettingsActionFactory factory;

	public MenuSettingsController(IFrameView frameView) {
		this.frameView = frameView;
		factory = new MenuSettingsActionFactory();
	}

	public void setGamepad(Gamepad gamepad) {
		factory.setGamepad(gamepad);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		factory.make(event.getActionCommand()).execute(frameView);
	}
}
