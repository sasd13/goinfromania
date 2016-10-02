package com.sasd13.goinfromania.controller;

import com.sasd13.goinfromania.bean.setting.Gamepad;

public interface IGameView {
	
	void setGamepad(Gamepad gamepad);

	boolean askStop();

	boolean askSave();

	void displayResult();
}
