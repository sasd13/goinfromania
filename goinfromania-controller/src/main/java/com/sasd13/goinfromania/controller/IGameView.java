package com.sasd13.goinfromania.controller;

import java.util.Observer;

public interface IGameView extends Observer {

	boolean askStop();

	boolean askSave();

	void displayResult();
}
