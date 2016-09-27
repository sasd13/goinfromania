package com.sasd13.goinfromania.controller.menu.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.menu.MenuCommandFactory;
import com.sasd13.goinfromania.controller.ICommandFactory;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.menu.EnumMenuType;

public class MenuEditController implements ActionListener {

	private IFrame frame;
	private ICommandFactory commandFactory;

	public MenuEditController(IFrame frame) {
		this.frame = frame;
		commandFactory = MenuCommandFactory.make(EnumMenuType.EDIT.getCode());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		commandFactory.make(event.getActionCommand()).execute(frame);
	}
}
