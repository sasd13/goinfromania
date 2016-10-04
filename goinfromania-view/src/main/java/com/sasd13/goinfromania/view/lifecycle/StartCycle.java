package com.sasd13.goinfromania.view.lifecycle;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.view.GameView;
import com.sasd13.goinfromania.view.dialog.GameStarterDialog;

public class StartCycle implements ICycle {

	private GameStarterDialog gameStarterDialog;

	@Override
	public void execute(GameView gameView, Game game) {
		if (gameStarterDialog == null) {
			gameStarterDialog = new GameStarterDialog(gameView);
		}

		gameStarterDialog.display();
	}
}
