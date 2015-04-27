package game;

import java.util.Observable;

import game.round.ListRound;
import game.round.Round;

public class Game extends Observable {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";
	
	private ListRound listRound;
	private Round liveRound;
	
	private Game() {
		super();
		
		this.listRound = null;
		this.liveRound = null;
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
	
	public Round getLiveRound() {
		return this.liveRound;
	}
	
	public void setLiveRound(Round liveRound) {
		this.liveRound = liveRound;
		
		setChanged();
		notifyObservers();
	}
}
