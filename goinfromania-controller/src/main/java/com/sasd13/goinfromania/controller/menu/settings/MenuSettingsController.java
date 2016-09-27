package com.sasd13.goinfromania.controller.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.menu.EnumMenuType;
import com.sasd13.goinfromania.controller.menu.IMenuItemCommandFactory;
import com.sasd13.goinfromania.controller.menu.MenuCommandFactory;

public class MenuSettingsController implements ActionListener {

	private IMenuItemCommandFactory menuItemCommandFactory;

	public MenuSettingsController() {
		menuItemCommandFactory = MenuCommandFactory.make(EnumMenuType.SETTINGS.getCode());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		menuItemCommandFactory.make(event.getActionCommand()).execute();
	}
}
