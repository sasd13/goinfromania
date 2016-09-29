package com.sasd13.goinfromania.controller.menu.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.IFrame;

public class MenuEditController implements ActionListener {

	private IFrame frame;
	private MenuEditActionFactory factory;

	public MenuEditController(IFrame frame) {
		this.frame = frame;
		factory = new MenuEditActionFactory();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		factory.make(event.getActionCommand()).execute(frame);
	}
}
