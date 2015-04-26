package game.element.character;

import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class EnergyView extends JPanel implements Observer {

	private JLabel labelEnergy;
	private JProgressBar progressBarEnergyValue;
	
	public EnergyView() {
		super();
		
		setLayout(new FlowLayout());
		
		this.labelEnergy = new JLabel("Energy : ");
		add(this.labelEnergy);
		
		this.progressBarEnergyValue = new JProgressBar(Energy.ENERGY_MIN, Energy.ENERGY_MAX);
		add(this.progressBarEnergyValue);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Energy energy = (Energy) observable;
		
		this.progressBarEnergyValue.setValue(energy.getValue());
	}
}
