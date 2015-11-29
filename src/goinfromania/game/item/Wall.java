package goinfromania.game.item;

import goinfromania.game.Element;

public class Wall extends Element {

	public Wall() {}
	
	@Override
	public boolean isCrossable() {
		return false;
	}
}
