package com.sasd13.goinfromania.controller;

import java.util.Observable;
import java.util.Observer;

public class ElementController implements Observer {

	private IArenaView arenaView;

	public ElementController(IArenaView arenaView) {
		this.arenaView = arenaView;
	}

	@Override
	public void update(Observable o, Object arg) {
		arenaView.repaint();
	}
}
