package com.sasd13.goinfromania.controller.menu.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.ICommandFactory;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.menu.EnumMenuType;
import com.sasd13.goinfromania.controller.menu.MenuCommandFactory;

public class MenuFileController implements ActionListener {

	private IFrame frame;
	private ICommandFactory commandFactory;

	public MenuFileController(IFrame frame) {
		this.frame = frame;
		commandFactory = MenuCommandFactory.make(EnumMenuType.FILE.getCode());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		commandFactory.make(event.getActionCommand()).execute(frame);
	}
}
