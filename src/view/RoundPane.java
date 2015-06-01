package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.element.character.Pig;
import game.round.Round;
import game.round.Statistics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GameController;

public class RoundPane extends JPanel implements ActionListener {

	private Round round;
	
	private JLabel labelRoundNumberValue,
		labelLevelValue,
		labelCakesValue,
		labelCumulatedScoreValue,
		labelDateUpdatedValue,
		labelPigLifeValue,
		labelPigEnergyValue;
	
	private JButton buttonContinue, buttonRemove;
	
	public RoundPane() {
		super(new BorderLayout());
		
		this.round = null;
		
		JPanel panelProgression = new JPanel();
		add(panelProgression, BorderLayout.NORTH);
		
		panelProgression.add(new JLabel("Progression"));
		
		JPanel panelRound = new JPanel(new GridLayout(8, 2));
		add(panelRound, BorderLayout.CENTER);
		
		panelRound.add(new JLabel("Round number : "));
		this.labelRoundNumberValue = new JLabel();
		panelRound.add(this.labelRoundNumberValue);
		
		panelRound.add(new JLabel("Level : "));
		this.labelLevelValue = new JLabel();
		panelRound.add(this.labelLevelValue);
		
		panelRound.add(new JLabel("Cakes : "));
		this.labelCakesValue = new JLabel();
		panelRound.add(this.labelCakesValue);
		
		panelRound.add(new JLabel("Pig life : "));
		this.labelPigLifeValue = new JLabel();
		panelRound.add(this.labelPigLifeValue);
		
		panelRound.add(new JLabel("Pig energy : "));
		this.labelPigEnergyValue = new JLabel();
		panelRound.add(this.labelPigEnergyValue);
		
		panelRound.add(new JLabel("Cumulated score : "));
		this.labelCumulatedScoreValue = new JLabel();
		panelRound.add(this.labelCumulatedScoreValue);
		
		panelRound.add(new JLabel("Updated : "));
		this.labelDateUpdatedValue = new JLabel();
		panelRound.add(this.labelDateUpdatedValue);
		
		JPanel panelButton = new JPanel();
		add(panelButton, BorderLayout.SOUTH);
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonContinue = new JButton("Continue");
		this.buttonContinue.setPreferredSize(dimension);
		this.buttonContinue.setFocusable(false);
		this.buttonContinue.addActionListener(this);
		panelButton.add(this.buttonContinue);
		
		this.buttonRemove = new JButton("Remove");
		this.buttonRemove.setPreferredSize(dimension);
		this.buttonRemove.setFocusable(false);
		this.buttonRemove.addActionListener(this);
		panelButton.add(this.buttonRemove);
	}
	
	public void bind(Round round) {
		this.round = round;
		
		this.labelRoundNumberValue.setText(String.valueOf(round.getRoundNumber()));
		this.labelLevelValue.setText(String.valueOf(round.getLevel()));
		if (round.getDateUpdated() == null) {
			this.labelDateUpdatedValue.setText("");
		} else {
			this.labelDateUpdatedValue.setText(String.valueOf(round.getDateUpdated()));
		}
		
		Statistics statistics = round.getStatistics();
		this.labelCakesValue.setText(statistics.getCountEatenCakes() + "/" + statistics.getMaxCakesToEat());
		this.labelCumulatedScoreValue.setText(String.valueOf(statistics.getScore()));
		
		Pig pig = round.getListElements().getPig();
		
		this.labelPigLifeValue.setText(String.valueOf(pig.getLife()));
		this.labelPigEnergyValue.setText(String.valueOf(pig.getEnergy()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if (button == this.buttonContinue) {
			GameController.openRound(this.round);
		} else if (button == this.buttonRemove) {
			GameController.removeRound(this.round);
		}
	}
}
