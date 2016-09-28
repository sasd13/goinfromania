package com.sasd13.goinfromania.controller.descriptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.IFrame;

public class GameDescriptorController implements ActionListener {

	private IFrame frame;
	private IDescriptor descriptor;

	public GameDescriptorController(IFrame frame, IDescriptor descriptor) {
		this.frame = frame;
		this.descriptor = descriptor;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		GameDescriptorActionFactory.make(event.getActionCommand(), descriptor).execute(frame);
	}
}
