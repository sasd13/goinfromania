package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.Game;

public interface IStateProcessor {

	void process(int stateTarget, Game game);
}
