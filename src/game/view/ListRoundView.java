package game.view;

import game.Game;
import game.round.ListRound;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ListRoundView extends JPanel implements Observer {

	public ListRoundView() {
		super();
		
		setBackground(Color.BLUE);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		ListRound listRound = game.getListRound();
	}
}
