package game.round;

import game.IViewable;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ListRoundView extends JPanel implements Observer, IViewable {

	public ListRoundView() {
		super();
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		ListRound listRound = (ListRound) observable;
	}
	
	@Override
	public void display() {
		setVisible(true);
	}
	
	@Override
	public void mask() {
		setVisible(false);
	}
}
