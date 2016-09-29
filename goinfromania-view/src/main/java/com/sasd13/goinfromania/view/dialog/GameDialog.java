package com.sasd13.goinfromania.view.dialog;

import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.sasd13.goinfromania.controller.IDialog;

public abstract class GameDialog extends JDialog implements Observer, IDialog {

	protected GameDialog() {
		super();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setUndecorated(true);
	}
}
