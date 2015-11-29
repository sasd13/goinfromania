package goinfromania.game.item;

import goinfromania.Element;

public class Wall extends Element {

	public Wall() {}
	
	@Override
	public boolean isCrossable() {
		return false;
	}
}
