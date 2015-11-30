package goinfromania.controller;

import goinfromania.controller.engine.GameEngine;
import goinfromania.controller.engine.MoveEngine;
import goinfromania.game.Direction;
import goinfromania.game.character.pig.Pig;
import goinfromania.setting.GamePad;
import goinfromania.view.frame.ArenaView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArenaController implements KeyListener {
	
	private ArenaView arenaView;
	
	public ArenaController(ArenaView arenaView) {
		this.arenaView = arenaView;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		GamePad gamePad = GameEngine.getGame().getGamePad();
		Pig pig = GameEngine.getGame().getPig();
		
		if (keyCode == gamePad.getKeyStart()) {
			GameEngine.actionPause();
		} else if (keyCode == gamePad.getKeyMoveNorth()) {
			MoveEngine.move(pig, Direction.NORTH);
		} else if (keyCode == gamePad.getKeyMoveSouth()) {
			MoveEngine.move(pig, Direction.SOUTH);
		} else if (keyCode == gamePad.getKeyMoveWest()) {
			MoveEngine.move(pig, Direction.WEST);
		} else if (keyCode == gamePad.getKeyMoveEast()) {
			MoveEngine.move(pig, Direction.EAST);
		} else if (keyCode == gamePad.getKeyPigAttak()) {
			//TODO
		}
	}
}
