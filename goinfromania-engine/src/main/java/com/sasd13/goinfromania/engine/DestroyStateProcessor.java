package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;

public class DestroyStateProcessor implements IStateProcessor {

	@Override
	public void process(int stateTarget, Game game) {
		game.setState(EnumState.DESTROYED);
		game.deleteObservers();
	}
}
