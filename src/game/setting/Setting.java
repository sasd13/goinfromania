package game.setting;

import game.Model;

public abstract class Setting extends Model {
	
	protected Setting() {
		super();
		
		setTitle("Setting");
	}
	
	public abstract void reset();
}
