package goinfromania.controller;

import goinfromania.game.character.pig.Pig;
import goinfromania.view.frame.ArenaView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArenaController implements KeyListener {
	
	private Pig pig;
	
	private ArenaView arenaView;
	
	public ArenaController(ArenaView arenaView) {
		this.arenaView = arenaView;
	}
	
	public void setPig(Pig pig) {
		this.pig = pig;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
