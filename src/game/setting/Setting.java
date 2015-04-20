package game.setting;

import game.Model;

public abstract class Setting extends Model {
	
	protected Setting() {
		super();
	}
	
	public abstract void reset();
}
