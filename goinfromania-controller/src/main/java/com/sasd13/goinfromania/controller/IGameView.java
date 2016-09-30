package com.sasd13.goinfromania.controller;

import java.util.Observer;

import com.sasd13.goinfromania.bean.Game;

public interface IGameView extends Observer {
	
	void create(Game game);
	
	boolean askStop();
	
	boolean askSave();
	
	void displayResult();
}
