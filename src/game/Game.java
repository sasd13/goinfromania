package game;

import java.util.Observable;

import game.round.ListRound;
import game.round.Round;
import game.setting.MapSetting;

public class Game extends Observable {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";
	
	private MapSetting mapSetting;
	private ListRound listRound;
	private Round liveRound;
	
	private Game() {
		super();
		
		this.mapSetting = null;
		this.listRound = null;
		this.liveRound = null;
	}
	
	public static synchronized Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	public MapSetting getMapSetting() {
		return this.mapSetting;
	}
	
	public void setMapSetting(MapSetting mapSetting) {
		this.mapSetting = mapSetting;
		
		setChanged();
		notifyObservers();
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
