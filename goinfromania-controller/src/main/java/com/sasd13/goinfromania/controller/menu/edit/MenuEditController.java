package com.sasd13.goinfromania.controller.menu.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.menu.IMenuItemCommandFactory;
import com.sasd13.goinfromania.controller.menu.MenuCommandFactory;
import com.sasd13.goinfromania.controller.menu.EnumMenuType;

public class MenuEditController implements ActionListener {

	private IMenuItemCommandFactory menuItemCommandFactory;

	public MenuEditController() {
		menuItemCommandFactory = MenuCommandFactory.make(EnumMenuType.EDIT.getCode());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		menuItemCommandFactory.make(event.getActionCommand()).execute();
	}
}
