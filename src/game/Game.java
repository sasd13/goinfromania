package game;

import java.util.Observable;

import game.round.ListRound;

public class Game extends Observable {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";
	
	private ListRound listRound;
	
	private Game() {
		super();
		
		this.listRound = null;
	}
	
	public static synchronized Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	public ListRound getListRound() {
		return this.listRound;
	}
	
	public void setListRound(ListRound listRound) {
		this.listRound = listRound;
		
		setChanged();
		notifyObservers();
	}
}
