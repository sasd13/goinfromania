package view;

import game.element.character.Character;
import game.element.character.Pig;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PigStateView extends JPanel implements Observer {

	private JLabel labelLife, labelEnergy;
	private JProgressBar progressBarLifeValue, progressBarEnergyValue;
	
	public PigStateView() {
		super();
		
		setLayout(new GridLayout(1, 3));
		setPreferredSize(new Dimension(DimensionConstants.PANEL_STATE_WIDTH, DimensionConstants.PANEL_STATE_HEIGHT));
		
		JPanel panelLife = new JPanel();
		panelLife.setLayout(new FlowLayout());
		
		this.labelLife = new JLabel("Life : ");
		panelLife.add(this.labelLife);
		
		this.progressBarLifeValue = new JProgressBar(Character.LIFE_MIN, Character.LIFE_MAX);
		panelLife.add(this.progressBarLifeValue);
		
		add(panelLife);
		
		JPanel panelEnergy = new JPanel();
		panelEnergy.setLayout(new FlowLayout());
		
		this.labelEnergy = new JLabel("Energy : ");
		panelEnergy.add(this.labelEnergy);
		
		this.progressBarEnergyValue = new JProgressBar(Pig.ENERGY_MIN, Pig.ENERGY_MAX);
		panelEnergy.add(this.progressBarEnergyValue);
		
		add(panelEnergy);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Pig pig = (Pig) observable;
		
		this.progressBarLifeValue.setValue(pig.getLife());
		this.progressBarEnergyValue.setValue(pig.getEnergy());
	}
}
