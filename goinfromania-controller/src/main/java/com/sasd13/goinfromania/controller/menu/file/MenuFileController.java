package com.sasd13.goinfromania.controller.menu.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.menu.EnumMenuType;
import com.sasd13.goinfromania.controller.menu.IMenuItemCommandFactory;
import com.sasd13.goinfromania.controller.menu.MenuCommandFactory;

public class MenuFileController implements ActionListener {

	private IMenuItemCommandFactory menuItemCommandFactory;

	public MenuFileController() {
		menuItemCommandFactory = MenuCommandFactory.make(EnumMenuType.FILE.getCode());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		menuItemCommandFactory.make(event.getActionCommand()).execute();
	}
}