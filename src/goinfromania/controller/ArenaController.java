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
	
	private GamePad gamePad;
	private Pig pig;
	
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
		GameEngine gameEngine = GameEngine.getInstance();
		
		this.gamePad = gameEngine.getGame().getGamePad();
		this.pig = gameEngine.getGame().getPig();
		
		if (keyCode == this.gamePad.getKeyStart()) {
			gameEngine.actionPause();
		} else if (keyCode == this.gamePad.getKeyMoveNorth()) {
			MoveEngine.move(this.pig, Direction.NORTH);
		} else if (keyCode == this.gamePad.getKeyMoveSouth()) {
			MoveEngine.move(this.pig, Direction.SOUTH);
		} else if (keyCode == this.gamePad.getKeyMoveWest()) {
			MoveEngine.move(this.pig, Direction.WEST);
		} else if (keyCode == this.gamePad.getKeyMoveEast()) {
			MoveEngine.move(this.pig, Direction.EAST);
		} else if (keyCode == this.gamePad.getKeyPigAttak()) {
			//TODO
		}
	}
}
