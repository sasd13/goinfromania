package main.java.game;

import java.util.Observable;

import main.java.game.round.ListRounds;

public class Game extends Observable {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";

	private ListRounds listRounds;
	
	private Game() {
		super();
		
		this.listRounds = new ListRounds();
	}
	
	public static synchronized Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	public ListRounds getListRounds() {
		return this.listRounds;
	}
	
	public void setListRounds(ListRounds listRounds) {
		this.listRounds = listRounds;
		
		setChanged();
		notifyObservers();
	}
}
