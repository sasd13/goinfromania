package com.sasd13.goinfromania.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.IPig;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.engine.GameHandler;

public class ArenaController implements KeyListener {

	private IArena arena;
	private Game game;
	private Gamepad gamepad;

	public ArenaController(IArena arena) {
		this.arena = arena;
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
				GameHandler.pauseGame(game);
			} else {
				GameHandler.resumeGame(game);
			}
		} else if (game.getState() == EnumState.RESUMED) {
			IPig pig = game.getPig();

			if (keyCode == gamepad.getKeyMoveNorth()) {
				MoveHandler.move(pig, Direction.NORTH, arena);
			} else if (keyCode == gamepad.getKeyMoveSouth()) {
				MoveHandler.move(pig, Direction.SOUTH, arena);
			} else if (keyCode == gamepad.getKeyMoveWest()) {
				MoveHandler.move(pig, Direction.WEST, arena);
			} else if (keyCode == gamepad.getKeyMoveEast()) {
				MoveHandler.move(pig, Direction.EAST, arena);
			} else if (keyCode == gamepad.getKeyPigAttak()) {
				// TODO
			}
		}
	}
}
