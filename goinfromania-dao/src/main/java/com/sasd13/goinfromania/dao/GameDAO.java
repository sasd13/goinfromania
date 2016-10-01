package com.sasd13.goinfromania.dao;

import java.util.ArrayList;
import java.util.List;

import com.sasd13.goinfromania.bean.EnumLevel;
import com.sasd13.goinfromania.bean.Game;

public class GameDAO {
	
	private static List<Game> games = new ArrayList<>();
	
	static {
		games = new ArrayList<>();
		
		Game game;
		
		game = new Game();
		game.setLevel(EnumLevel.EASY);
		games.add(game);
		
		game = new Game();
		game.setLevel(EnumLevel.NORMAL);
		games.add(game);
		
		game = new Game();
		game.setLevel(EnumLevel.HARD);
		games.add(game);
	}
	
	public static void create(Game game) {
		//TODO Database query
	}
	
	public static void update(Game game) {
		//TODO Database query
	}
	
	public static void delete(Game game) {
		//TODO Database query
		games.remove(game);
	}

	public static Game load(long id) {
		Game game = null;
		
		//TODO Database query
		
		return game;
	}
	
	public static List<Game> loadAll() {
		List<Game> list = new ArrayList<>();
		
		//TODO Database query
		
		//return list;
		return games;
	}
}
