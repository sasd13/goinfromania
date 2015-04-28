package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundStateView extends JPanel {

	private JLabel labelRound,
		labelRoundValue,
		labelScore,
		labelScoreValue;
	
	public RoundStateView() {
		super();
		
		setLayout(new GridLayout(1, 2));
		
		JPanel panelRound = new JPanel();
		panelRound.setLayout(new FlowLayout());
		
		this.labelRound = new JLabel("Round : ");
		panelRound.add(this.labelRound);
		this.labelRoundValue = new JLabel();
		panelRound.add(this.labelRoundValue);
		
		add(panelRound);
		
		JPanel panelScore = new JPanel();
		panelRound.setLayout(new FlowLayout());
		
		this.labelScore = new JLabel("Score : ");
		panelScore.add(this.labelScore);
		this.labelScoreValue = new JLabel();
		panelScore.add(this.labelScoreValue);
		
		add(panelScore);
	}
	
	public JLabel getLabelRoundValue() {
		return this.labelRoundValue;
	}
	
	public JLabel getLabelScoreValue() {
		return this.labelScoreValue;
	}
}
