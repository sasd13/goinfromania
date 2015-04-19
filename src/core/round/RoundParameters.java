package core.round;

import core.IParameterizable;
import core.IViewer;

public class RoundParameters implements IParameterizable {
	
	private Level level;
	
	public RoundParameters() {
		setDefault();
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void setDefault() {
		this.level = Level.EASY;
	}
	
	@Override
	public IViewer show() {
		return null;
	}
}
