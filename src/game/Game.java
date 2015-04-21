package game;

import game.round.ListRound;
import game.round.Round;
import game.round.RoundManager;
import game.setting.SettingManager;
import game.setting.SettingType;
import game.setting.MapSetting;
import game.setting.Setting;

public class Game extends Model {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";
	
	private MapSetting mapSetting;
	private ListRound listRound;
	
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
	
	public void initialize() {
		loadSettings();
		loadRounds();
	}
	
	public void loadSettings() {
		this.mapSetting = SettingManager.loadAll();
		
		notifyObservers();
	}
	
	public Setting newSetting(Setting setting) {
		setting = this.mapSetting.put(setting);
		
		notifyObservers();
		
		return setting;
	}
	
	public Setting deleteSetting(Setting setting) {
		setting = this.mapSetting.remove(setting);
		
		notifyObservers();
		
		return setting;
	}
	
	public Setting getSetting(SettingType settingType) {
		return this.mapSetting.get(settingType);
	}
	
	public void loadRounds() {
		this.listRound = RoundManager.loadAll();
		
		notifyObservers();
	}
	
	public Round newRound() {
		Round round = new Round();
		this.listRound.add(round);
		
		notifyObservers();
		
		return round;
	}
	
	public boolean deleteRound(Round round) {
		boolean deleted = this.listRound.remove(round);
		
		notifyObservers();
		
		return deleted;
	}
	
	public Round getRound(String roundId) {
		return this.listRound.get(roundId);
	}
	
	public void exit() {
		
	}
}
