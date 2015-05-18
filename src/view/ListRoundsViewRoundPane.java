package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.element.character.Pig;
import game.round.Round;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GameController;

public class ListRoundsViewRoundPane extends JPanel implements ActionListener {

	private Round round;
	
	private JLabel labelRoundNumberValue,
		labelLevelValue,
		labelCakesValue,
		labelScoreValue,
		labelDateUpdatedValue,
		labelPigLifeValue,
		labelPigEnergyValue;
	
	private JButton buttonContinue, buttonRemove;
	
	public ListRoundsViewRoundPane() {
		super(new BorderLayout());
		
		this.round = null;
		
		JPanel panelProgression = new JPanel();
		add(panelProgression, BorderLayout.NORTH);
		
		panelProgression.add(new JLabel("Progression"));
		
		JPanel panelRound = new JPanel(new GridLayout(7, 2));
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
		
		panelRound.add(new JLabel("Score : "));
		this.labelScoreValue = new JLabel();
		panelRound.add(this.labelScoreValue);
		
		panelRound.add(new JLabel("Updated : "));
		this.labelDateUpdatedValue = new JLabel();
		panelRound.add(this.labelDateUpdatedValue);
		
		panelRound.add(new JLabel("Pig life : "));
		this.labelPigLifeValue = new JLabel();
		panelRound.add(this.labelPigLifeValue);
		
		panelRound.add(new JLabel("Pig energy : "));
		this.labelPigEnergyValue = new JLabel();
		panelRound.add(this.labelPigEnergyValue);
		
		JPanel panelButton = new JPanel();
		add(panelButton, BorderLayout.SOUTH);
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonContinue = new JButton("Continue");
		this.buttonContinue.setPreferredSize(dimension);
		this.buttonContinue.addActionListener(this);
		panelButton.add(this.buttonContinue);
		
		this.buttonRemove = new JButton("Remove");
		this.buttonRemove.setPreferredSize(dimension);
		this.buttonRemove.addActionListener(this);
		panelButton.add(this.buttonRemove);
	}
	
	public void bind(Round round) {
		this.round = round;
		
		this.labelRoundNumberValue.setText(String.valueOf(round.getRoundNumber()));
		this.labelLevelValue.setText(String.valueOf(round.getLevel()));
		this.labelCakesValue.setText(round.getCountEatenCakes() + "/" + round.getMaxCountEatenCakes());
		this.labelScoreValue.setText(String.valueOf(round.getScore()));
		this.labelDateUpdatedValue.setText(String.valueOf(round.getUpdatedAt()));
		
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
