package core.round;

import core.IViewer;
import core.params.Params;

public class RoundParameters extends Params {
	
	private Level level;
	
	public RoundParameters() {
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
