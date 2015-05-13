package view.round;

import game.element.character.Character;
import game.element.character.Pig;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import view.DimensionConstants;

public class PigStateView extends JPanel implements Observer {

	private JProgressBar progressBarLifeValue, progressBarEnergyValue;
	
	public PigStateView() {
		super(new GridLayout(1, 3));
		
		setPreferredSize(new Dimension(DimensionConstants.PANEL_STATE_WIDTH, DimensionConstants.PANEL_STATE_HEIGHT));
		
		JPanel panelLife = new JPanel();
		add(panelLife);
		
		panelLife.add(new JLabel("Life : "));
		this.progressBarLifeValue = new JProgressBar(Character.LIFE_MIN, Character.LIFE_MAX);
		panelLife.add(this.progressBarLifeValue);
		
		JPanel panelEnergy = new JPanel();
		add(panelEnergy);
		
		panelEnergy.add(new JLabel("Energy : "));
		this.progressBarEnergyValue = new JProgressBar(Pig.ENERGY_MIN, Pig.ENERGY_MAX);
		panelEnergy.add(this.progressBarEnergyValue);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Pig pig = (Pig) observable;
		
		this.progressBarLifeValue.setValue(pig.getLife());
		this.progressBarEnergyValue.setValue(pig.getEnergy());
	}
}
