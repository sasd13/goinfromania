package com.sasd13.goinfromania.view.lifecycle;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.view.GameView;
import com.sasd13.goinfromania.view.arena.ArenaView;

public interface ICycle {

	void execute(Game game, GameView gameView, ArenaView arenaView);
}
