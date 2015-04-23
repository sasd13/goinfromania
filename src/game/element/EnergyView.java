package game.element;

import game.round.PanelView;

import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class EnergyView extends PanelView {

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
		
		super.update(observable, null);
	}
}
