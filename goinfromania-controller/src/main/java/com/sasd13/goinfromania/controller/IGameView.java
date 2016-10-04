package com.sasd13.goinfromania.controller;

import java.util.Observer;

import com.sasd13.goinfromania.bean.Arena;
import com.sasd13.goinfromania.bean.Game;

public interface IGameView extends Observer {
	
	IArenaView displayArena(Arena arena);

	boolean askStop();

	boolean askSave();

	void displayResult(Game game);
}
