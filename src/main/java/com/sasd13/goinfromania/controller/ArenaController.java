package com.sasd13.goinfromania.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.character.pig.Pig;
import com.sasd13.goinfromania.bean.setting.GamePad;
import com.sasd13.goinfromania.engine.GameEngine;
import com.sasd13.goinfromania.engine.MoveEngine;
import com.sasd13.goinfromania.engine.PigEngine;

public class ArenaController implements KeyListener {
	
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
		GamePad gamePad = GameEngine.getGamePad();
		
		if (keyCode == gamePad.getKeyStart()) {
			GameEngine.pauseOrResumeGame();
		} else {
			Pig pig = PigEngine.findPig(GameEngine.getGame().getElements());
			
			if (keyCode == gamePad.getKeyMoveNorth()) {
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
}
