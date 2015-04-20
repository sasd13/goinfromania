package game.round;

import game.setting.Setting;

public class RoundSetting extends Setting {
	
	private Level level;
	
	public RoundSetting() {
		super();
		
		reset();
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
		
		notifyObservers();
	}

	@Override
	public void reset() {
		this.level = Level.NORMAL;
	}
}
