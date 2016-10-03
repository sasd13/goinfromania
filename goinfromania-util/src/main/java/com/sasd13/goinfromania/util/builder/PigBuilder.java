package com.sasd13.goinfromania.util.builder;

import java.awt.Dimension;
import java.awt.Point;

import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.util.GameConstants;

public class PigBuilder implements IBuilder<Pig> {

	@Override
	public Pig build() {
		Pig pig = new Pig();

		pig.setCrossable(true);
		pig.setDimension(new Dimension(GameConstants.DIMENSION_WIDTH_MAX, GameConstants.DIMENSION_HEIGHT_MAX));
		pig.setGreedy(true);
		pig.setEnergy(GameConstants.ENERGY_MIN);
		pig.setLife(GameConstants.LIFE_MAX);
		pig.setMovable(true);
		pig.setPosition(new Point(GameConstants.POSITION_X_MIN, GameConstants.POSITION_Y_MIN));
		pig.setPowerful(true);
		pig.setSpeed(GameConstants.SPEED_MEDIUM);

		return pig;
	}

}
