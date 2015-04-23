package game.round;

import java.util.Observable;

public class ListRoundView extends PanelView {

	public ListRoundView() {
		super();
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		ListRound listRound = (ListRound) observable;
		
		super.update(observable, arg);
	}
}
