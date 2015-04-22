package game.element;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JProgressBar;

public class EnergyView extends JProgressBar implements Observer {

	public EnergyView() {
		super(Energy.MIN_VALUE, Energy.MAX_VALUE);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Energy energy = (Energy) observable;
		
		setValue(energy.getValue());
	}
}
