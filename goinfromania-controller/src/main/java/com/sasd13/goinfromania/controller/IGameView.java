package com.sasd13.goinfromania.controller;

import java.util.Observer;

import com.sasd13.goinfromania.bean.Game;

public interface IGameView extends Observer {

	boolean askStop();

	boolean askSave();

	IDialogView displayResult(Game game);
}
