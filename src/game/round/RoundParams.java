package game.round;

import game.params.Params;

public class RoundParams extends Params {
	
	private Level level;
	
	public RoundParams() {
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
