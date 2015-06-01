package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.element.character.Pig;
import game.round.Round;
import game.round.Statistics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.GameController;

public class RoundPane extends JPanel implements ActionListener {

	private Round round;
	
	private JLabel labelRoundNumber,
		labelLevel,
		labelCakes,
		labelTotalScore,
		labelDateUpdated,
		labelPigLife,
		labelPigEnergy;
	
	private JButton buttonContinue, buttonRemove;
	
	public RoundPane() {
		super(new BorderLayout());
		
		this.round = null;
		
		add(new JLabel("Progression", SwingConstants.CENTER), BorderLayout.NORTH);
		
		Font font = new Font(
				getFont().getName(),
				Font.PLAIN,
				getFont().getSize());
		
		JPanel panelRound = new JPanel(new GridLayout(8, 2));
		add(panelRound, BorderLayout.CENTER);
		
		panelRound.add(new JLabel("Round number : "));
		this.labelRoundNumber = new JLabel();
		this.labelRoundNumber.setFont(font);
		panelRound.add(this.labelRoundNumber);
		
		panelRound.add(new JLabel("Level : "));
		this.labelLevel = new JLabel();
		this.labelLevel.setFont(font);
		panelRound.add(this.labelLevel);
		
		panelRound.add(new JLabel("Cakes : "));
		this.labelCakes = new JLabel();
		this.labelCakes.setFont(font);
		panelRound.add(this.labelCakes);
		
		panelRound.add(new JLabel("Pig life : "));
		this.labelPigLife = new JLabel();
		this.labelPigLife.setFont(font);
		panelRound.add(this.labelPigLife);
		
		panelRound.add(new JLabel("Pig energy : "));
		this.labelPigEnergy = new JLabel();
		this.labelPigEnergy.setFont(font);
		panelRound.add(this.labelPigEnergy);
		
		panelRound.add(new JLabel("Total score : "));
		this.labelTotalScore = new JLabel();
		this.labelRoundNumber.setFont(font);
		panelRound.add(this.labelTotalScore);
		
		panelRound.add(new JLabel("Date updated : "));
		this.labelDateUpdated = new JLabel();
		this.labelRoundNumber.setFont(font);
		panelRound.add(this.labelDateUpdated);
		
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
		
		this.labelRoundNumber.setText(String.valueOf(round.getRoundNumber()));
		this.labelLevel.setText(String.valueOf(round.getLevel()));
		if (round.getDateUpdated() == null) {
			this.labelDateUpdated.setText("");
		} else {
			this.labelDateUpdated.setText(String.valueOf(round.getDateUpdated()));
		}
		
		Statistics statistics = round.getStatistics();
		this.labelCakes.setText(statistics.getCountEatenCakes() + "/" + statistics.getMaxCakesToEat());
		this.labelTotalScore.setText(String.valueOf(statistics.getScore()));
		
		Pig pig = round.getListElements().getPig();
		
		this.labelPigLife.setText(String.valueOf(pig.getLife()));
		this.labelPigEnergy.setText(String.valueOf(pig.getEnergy()));
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
