package game.element;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class EnergyView extends JPanel implements Observer {

	private JLabel labelTitle;
	private JProgressBar progressBarEnergy;
	
	public EnergyView() {
		super();
		
		this.labelTitle = new JLabel();
		
		this.progressBarEnergy = new JProgressBar(Energy.MIN_VALUE, Energy.MAX_VALUE);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Energy energy = (Energy) observable;
		
		this.labelTitle.setText(energy.getTitle());
		
		this.progressBarEnergy.setValue(energy.getValue());
	}
}
