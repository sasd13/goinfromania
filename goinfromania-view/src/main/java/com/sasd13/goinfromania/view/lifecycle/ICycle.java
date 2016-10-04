package com.sasd13.goinfromania.view.lifecycle;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.view.GameView;

public interface ICycle {

	void execute(GameView gameView, Game game);
}
