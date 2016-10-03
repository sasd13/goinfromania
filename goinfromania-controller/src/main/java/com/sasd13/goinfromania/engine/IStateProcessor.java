package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;

public interface IStateProcessor {

	void process(int stateTarget, Game game, IGameView gameView);
}
