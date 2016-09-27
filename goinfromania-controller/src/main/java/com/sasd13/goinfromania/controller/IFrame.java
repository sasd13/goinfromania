package com.sasd13.goinfromania.controller;

import java.util.List;

import com.sasd13.goinfromania.bean.Game;

public interface IFrame {

	void displayHome();

	void displayGames(List<Game> games);

	void displayGame(Game game);
}
