package com.sasd13.goinfromania.controller.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.menu.EnumMenuType;
import com.sasd13.goinfromania.controller.menu.IMenuCommandFactory;
import com.sasd13.goinfromania.controller.menu.MenuCommandFactory;

public class MenuSettingsController implements ActionListener {

	private IFrame frame;
	private IMenuCommandFactory menuCommandFactory;

	public MenuSettingsController(IFrame frame) {
		this.frame = frame;
		menuCommandFactory = MenuCommandFactory.make(EnumMenuType.SETTINGS.getCode());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		menuCommandFactory.make(event.getActionCommand()).execute(frame);
	}
}
