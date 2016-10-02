package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;

public class StopStateProcessor implements IStateProcessor {

	private IFrame frame;
	private DestroyStateProcessor next;

	public StopStateProcessor(IFrame frame) {
		this.frame = frame;
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (frame.getGameView().askStop()) {
			if (game.getState().getOrder() < EnumState.STOPPED.getOrder()) {
				if (frame.getGameView().askSave()) {
					GameDAO.update(game);
				}

				stopGame(game);
			}

			if (stateTarget > EnumState.STOPPED.getOrder()) {
				if (next == null) {
					next = new DestroyStateProcessor();
				}

				next.process(stateTarget, game);
			}
		}
	}

	private void stopGame(Game game) {
		game.setState(EnumState.STOPPED);
		// TODO : process
	}
}
