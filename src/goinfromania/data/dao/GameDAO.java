package goinfromania.data.dao;

import java.util.ArrayList;
import java.util.List;

import goinfromania.Game;

public class GameDAO {
	
	public static void create(Game game) {
		//TODO Database query
	}
	
	public static void update(Game game) {
		//TODO Database query
	}
	
	public static void delete(Game game) {
		//TODO Database query
	}

	public static Game load(long id) {
		Game game = null;
		
		//TODO Database query
		
		return game;
	}
	
	public static List<Game> loadAll() {
		List<Game> list = new ArrayList<>();
		
		//TODO Database query
		
		return list;
	}
}
