package com.sasd13.goinfromania.controller.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.IDialog;
import com.sasd13.goinfromania.controller.IFrame;

public class GameResultController implements ActionListener {

	private IFrame frame;
	private IDialog dialog;

	public GameResultController(IFrame frame, IDialog dialog) {
		this.frame = frame;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		GameResultActionFactory.make(event.getActionCommand(), dialog).execute(frame);
	}
}
