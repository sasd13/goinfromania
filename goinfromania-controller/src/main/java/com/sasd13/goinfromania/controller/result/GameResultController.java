package com.sasd13.goinfromania.controller.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.IFrame;

public class GameResultController implements ActionListener {

	private IFrame frame;

	public GameResultController(IFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		GameResultCommandFactory.make(event.getActionCommand()).execute(frame);
	}
}
