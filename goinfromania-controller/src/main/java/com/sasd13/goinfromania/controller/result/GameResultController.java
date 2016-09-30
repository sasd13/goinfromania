package com.sasd13.goinfromania.controller.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IDialog;
import com.sasd13.goinfromania.controller.IFrame;

public class GameResultController implements ActionListener {

	private IFrame frame;
	private IDialog dialog;
	private Game game;

	public GameResultController(IFrame frame, IDialog dialog, Game game) {
		this.frame = frame;
		this.dialog = dialog;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		GameResultActionFactory.make(event.getActionCommand(), dialog, game).execute(frame);
	}
}
