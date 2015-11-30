package goinfromania.game.item;

import goinfromania.game.Element;

public class Wall extends Element {

	@Override
	public boolean isCrossable() {
		return false;
	}
	
	@Override
	public String getName() {
		return "WALL";
	}
}
