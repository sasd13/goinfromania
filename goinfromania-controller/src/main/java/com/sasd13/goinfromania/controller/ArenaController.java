package com.sasd13.goinfromania.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.bean.setting.GamePad;
import com.sasd13.goinfromania.util.MoveUtil;

public class ArenaController implements KeyListener {
	
	private GameEngine gameEngine = GameEngine.getInstance();

	@Override
	public void keyPressed(KeyEvent e) {
		//Do nothing
	}

	@Override
	public void keyReleased(KeyEvent e) {
		actionGamePad(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		actionGamePad(e.getKeyCode());
	}

	public void actionGamePad(int keyCode) {
		GamePad gamePad = gameEngine.getGamePad();

		if (keyCode == gamePad.getKeyStart()) {
			if (gameEngine.isGamePaused()) {
				gameEngine.onResume();
			} else {
				gameEngine.onPause();
			}
		} else {
			Pig pig = gameEngine.getGame().getPig();

			if (keyCode == gamePad.getKeyMoveNorth()) {
				MoveUtil.move(pig, Direction.NORTH);
			} else if (keyCode == gamePad.getKeyMoveSouth()) {
				MoveUtil.move(pig, Direction.SOUTH);
			} else if (keyCode == gamePad.getKeyMoveWest()) {
				MoveUtil.move(pig, Direction.WEST);
			} else if (keyCode == gamePad.getKeyMoveEast()) {
				MoveUtil.move(pig, Direction.EAST);
			} else if (keyCode == gamePad.getKeyPigAttak()) {
				// TODO
			}
		}
	}
}
