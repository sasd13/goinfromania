package game;

import java.util.Observable;

import game.round.ListRounds;

public class Game extends Observable {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";

	private ListRounds listRounds;
	
	private Game() {
		super();
		
		this.listRounds = null;
	}
	
	public static synchronized Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	public ListRounds getListRound() {
		return this.listRounds;
	}
	
	public void setListRound(ListRounds listRounds) {
		this.listRounds = listRounds;
		
		setChanged();
		notifyObservers();
	}
}
