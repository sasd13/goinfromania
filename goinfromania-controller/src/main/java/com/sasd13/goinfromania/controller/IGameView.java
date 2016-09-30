package com.sasd13.goinfromania.controller;

import com.sasd13.goinfromania.bean.Game;

public interface IGameView {
	
	void start(Game game);
	
	void resume();

	void pause();
	
	boolean stop();
	
	void finish();
	
	void displayResult();
}
