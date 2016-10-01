package com.sasd13.goinfromania.util.builder;

import java.util.ArrayList;
import java.util.List;

import com.sasd13.goinfromania.bean.Game;

public class GamesListStringBuilder implements IBuilder<List<String>> {
	
	private List<Game> games;
	
	public GamesListStringBuilder(List<Game> games) {
		this.games = games;
	}

	@Override
	public List<String> build() {
		List<String> list = new ArrayList<>();
		
		for (Game game : games) {
			list.add(String.valueOf(game.getDateCreation()));
		}
		
		return list;
	}
}
