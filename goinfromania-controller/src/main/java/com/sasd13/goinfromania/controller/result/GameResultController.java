package com.sasd13.goinfromania.controller.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IDialogView;
import com.sasd13.goinfromania.controller.IFrameView;

public class GameResultController implements ActionListener {

	private IFrameView frameView;
	private IDialogView dialogView;
	private Game game;

	public GameResultController(IFrameView frameView, IDialogView dialogView, Game game) {
		this.frameView = frameView;
		this.dialogView = dialogView;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		GameResultActionFactory.make(event.getActionCommand(), dialogView, game).execute(frameView);
	}
}
