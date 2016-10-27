package com.sasd13.goinfromania.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sasd13.goinfromania.bean.Arena;
import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.IPig;
import com.sasd13.goinfromania.bean.setting.Gamepad;

public class ArenaController implements KeyListener, FocusListener {

	private Gamepad gamepad;
	private Arena arena;

	public ArenaController(Gamepad gamepad) {
		this.gamepad = gamepad;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
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
			if (arena.getGame().getState() == EnumState.RESUMED) {
				GameHandler.pauseGame(arena.getGame());
			} else {
				GameHandler.resumeGame(arena.getGame());
			}
		} else if (arena.getGame().getState() == EnumState.RESUMED) {
			IPig pig = arena.getPig();

			if (keyCode == gamepad.getKeyMoveNorth()) {
				MoveHandler.move(pig, Direction.NORTH);
			} else if (keyCode == gamepad.getKeyMoveSouth()) {
				MoveHandler.move(pig, Direction.SOUTH);
			} else if (keyCode == gamepad.getKeyMoveWest()) {
				MoveHandler.move(pig, Direction.WEST);
			} else if (keyCode == gamepad.getKeyMoveEast()) {
				MoveHandler.move(pig, Direction.EAST);
			} else if (keyCode == gamepad.getKeyPigAttak()) {
				// TODO
			}
		}
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// Do nothing
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		GameHandler.pauseGame(arena.getGame());
	}
}
