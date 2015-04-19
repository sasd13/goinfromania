package core.round;

import core.params.Params;

public class RoundParams extends Params {
	
	private Level level;
	
	public RoundParams() {
		reset();
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void reset() {
		this.level = Level.NORMAL;
	}
}
