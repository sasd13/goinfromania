package game;

import game.round.ListRound;
import game.round.Round;
import game.setting.MapSetting;

public class Game extends Model {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";
	
	private MapSetting mapSetting;
	private ListRound listRound;
	private Round round;
	
	private Game() {
		super();
		
		setTitle(NAME);
	}
	
	public static synchronized Game getInstance() {
		if(instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	public MapSetting getMapSetting() {
		return this.mapSetting;
	}
	
	public void setMapSetting(MapSetting mapSetting) {
		this.mapSetting = mapSetting;
		
		notifyObservers();
	}
	
	public ListRound getListRound() {
		return this.listRound;
	}
	
	public void setListRound(ListRound listRound) {
		this.listRound = listRound;
		
		notifyObservers();
	}
	
	public Round getRound() {
		return this.round;
	}
	
	public void setRound(Round round) {
		this.round = round;
		
		notifyObservers();
	}
}
