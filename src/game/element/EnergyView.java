package game.element;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class EnergyView extends JPanel implements Observer {

	private JLabel labelTitle;
	private JProgressBar progressBarEnergy;
	
	public EnergyView() {
		super();
		
		this.labelTitle = new JLabel();
		
		this.progressBarEnergy = new JProgressBar(Energy.ENERGY_MIN, Energy.ENERGY_MAX);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Energy energy = (Energy) observable;
		
		this.labelTitle.setText(energy.getTitle());
		
		this.progressBarEnergy.setValue(energy.getValue());
		this.progressBarEnergy.setValue(energy.getValue());
		if (energy.getValue() >= Energy.ENERGY_MEDIUM) {
			UIManager.put("ProgressBar.foreground", Color.GREEN);
		} else if (energy.getValue() < Energy.ENERGY_MEDIUM && energy.getValue() >= Energy.ENERGY_LOW) {
			UIManager.put("ProgressBar.foreground", Color.ORANGE);
		} else {
			UIManager.put("ProgressBar.foreground", Color.RED);
		}
	}
}
