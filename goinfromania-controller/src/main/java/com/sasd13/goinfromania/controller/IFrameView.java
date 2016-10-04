package com.sasd13.goinfromania.controller;

import java.util.List;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.Setting;

public interface IFrameView {

	void displayHome();

	void displayGames(List<Game> games);

	IGameView displayGame(Game game);

	IDialogView displaySetting(Setting setting);

	boolean askClose();

	void dispose();
}
