package game.round;

import game.GameView;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ListRoundView extends JPanel implements Observer {

	public ListRoundView() {
		super();
		
		setPreferredSize(new Dimension(GameView.GAMECONTENTPANE_WIDTH, GameView.GAMECONTENTPANE_HEIGHT));
		setBackground(Color.BLUE);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		ListRound listRound = (ListRound) observable;
	}
}
