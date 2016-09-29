package com.sasd13.goinfromania.controller.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.IFrame;

public class MenuSettingsController implements ActionListener {

	private IFrame frame;
	private MenuSettingsActionFactory factory;

	public MenuSettingsController(IFrame frame) {
		this.frame = frame;
		factory = new MenuSettingsActionFactory();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		factory.make(event.getActionCommand()).execute(frame);
	}
}
