package com.sasd13.goinfromania.controller;

import java.util.List;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.Setting;

public interface IFrame {

	void displayHome();

	void displayGames(List<Game> games);

	void displayGame(Game game);

	void displaySetting(Setting setting);

	boolean close();
}
