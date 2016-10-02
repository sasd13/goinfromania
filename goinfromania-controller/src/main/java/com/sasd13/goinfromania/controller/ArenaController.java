package com.sasd13.goinfromania.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.IPig;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.engine.GameEngine;
import com.sasd13.goinfromania.util.MoveUtil;

public class ArenaController implements KeyListener {

	private IFrame frame;
	private Game game;
	private Gamepad gamepad;

	public ArenaController(IFrame frame) {
		this.frame = frame;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setGamepad(Gamepad gamepad) {
		this.gamepad = gamepad;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Do nothing
	}

	@Override
	public void keyReleased(KeyEvent e) {
		actionGamepad(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		actionGamepad(e.getKeyCode());
	}

	public void actionGamepad(int keyCode) {
		if (keyCode == gamepad.getKeyStart()) {
			if (game.getState() == EnumState.RESUMED) {
				GameEngine.pauseGame(game, frame);
			} else {
				GameEngine.resumeGame(game, frame);
			}
		} else {
			IPig pig = game.getPig();

			if (keyCode == gamepad.getKeyMoveNorth()) {
				MoveUtil.move(pig, Direction.NORTH);
			} else if (keyCode == gamepad.getKeyMoveSouth()) {
				MoveUtil.move(pig, Direction.SOUTH);
			} else if (keyCode == gamepad.getKeyMoveWest()) {
				MoveUtil.move(pig, Direction.WEST);
			} else if (keyCode == gamepad.getKeyMoveEast()) {
				MoveUtil.move(pig, Direction.EAST);
			} else if (keyCode == gamepad.getKeyPigAttak()) {
				// TODO
			}
		}
	}
}
