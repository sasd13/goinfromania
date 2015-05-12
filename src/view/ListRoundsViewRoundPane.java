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
		super();
		
		setLayout(new BorderLayout());
		
		this.round = null;
		
		JPanel panelProgression = new JPanel();
		JLabel labelProgression = new JLabel("Progression");
		labelProgression.setAlignmentX(CENTER_ALIGNMENT);
		panelProgression.add(labelProgression);
		add(panelProgression, BorderLayout.NORTH);
		
		JPanel panel = new JPanel(new GridLayout(7, 2));
		
		JLabel labelRoundNumber = new JLabel("Round number : ");
		panel.add(labelRoundNumber);
		
		this.labelRoundNumberValue = new JLabel();
		panel.add(this.labelRoundNumberValue);
		
		JLabel labelLevel = new JLabel("Level : ");
		panel.add(labelLevel);
		
		this.labelLevelValue = new JLabel();
		panel.add(this.labelLevelValue);
		
		JLabel labelCakes = new JLabel("Cakes : ");
		panel.add(labelCakes);
		
		this.labelCakesValue = new JLabel();
		panel.add(this.labelCakesValue);
		
		JLabel labelScore = new JLabel("Score : ");
		panel.add(labelScore);
		
		this.labelScoreValue = new JLabel();
		panel.add(this.labelScoreValue);
		
		JLabel labelDateUpdated = new JLabel("Updated : ");
		panel.add(labelDateUpdated);
		
		this.labelDateUpdatedValue = new JLabel();
		panel.add(this.labelDateUpdatedValue);
		
		JLabel labelPigLife = new JLabel("Pig life : ");
		panel.add(labelPigLife);
		
		this.labelPigLifeValue = new JLabel();
		panel.add(this.labelPigLifeValue);
		
		JLabel labelPigEnergy = new JLabel("Pig energy : ");
		panel.add(labelPigEnergy);
		
		this.labelPigEnergyValue = new JLabel();
		panel.add(this.labelPigEnergyValue);
		
		add(panel, BorderLayout.CENTER);
		
		JPanel panelButton = new JPanel();
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonContinue = new JButton("Continue");
		this.buttonContinue.setPreferredSize(dimension);
		this.buttonContinue.addActionListener(this);
		panelButton.add(this.buttonContinue);
		
		this.buttonRemove = new JButton("Remove");
		this.buttonRemove.setPreferredSize(dimension);
		this.buttonRemove.addActionListener(this);
		panelButton.add(this.buttonRemove);
		
		add(panelButton, BorderLayout.SOUTH);
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
			GameController.getInstance().openRound(this.round);
		} else if (button == this.buttonRemove) {
			GameController.getInstance().removeRound(this.round);
		}
	}
}
