package view;

import game.Game;
import game.round.ListRounds;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ListRoundView extends JPanel implements Observer {

	public ListRoundView() {
		super();
		
		Dimension dimension = new Dimension(DimensionConstants.GRID_WIDTH, DimensionConstants.GRID_HEIGHT);
		setPreferredSize(dimension);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		ListRounds listRounds = game.getListRound();
	}
}
