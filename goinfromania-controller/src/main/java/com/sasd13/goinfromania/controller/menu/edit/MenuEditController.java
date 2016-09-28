package com.sasd13.goinfromania.controller.menu.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.menu.MenuCommandFactory;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.menu.EnumMenuType;
import com.sasd13.goinfromania.controller.menu.IMenuCommandFactory;

public class MenuEditController implements ActionListener {

	private IFrame frame;
	private IMenuCommandFactory menuCommandFactory;

	public MenuEditController(IFrame frame) {
		this.frame = frame;
		menuCommandFactory = MenuCommandFactory.make(EnumMenuType.EDIT.getCode());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		menuCommandFactory.make(event.getActionCommand()).execute(frame);
	}
}
