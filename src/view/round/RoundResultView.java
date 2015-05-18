package view.round;

import game.round.Result;
import game.round.Round;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import view.DimensionConstants;
import controller.GameController;
import controller.RoundController;

public class RoundResultView extends JDialog implements Observer, ActionListener {

	private JLabel labelMessage,
		labelTotalScoreValue,
		labelTotalFoodEatedValue,
		labelTotalEnemyKilledValue;
	
	private JButton buttonNext, buttonFinish;
	
	public RoundResultView() {
		super();
		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(new Dimension(DimensionConstants.ROUND_COMPONENT_WIDTH, DimensionConstants.ROUND_COMPONENT_HEIGHT));
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		JPanel panelMessage = new JPanel();
		getContentPane().add(panelMessage, BorderLayout.NORTH);
		
		this.labelMessage = new JLabel("Message");
		panelMessage.add(this.labelMessage);
		
		JPanel panelResult = new JPanel(new GridLayout(3, 2));
		getContentPane().add(panelResult, BorderLayout.CENTER);
		
		panelResult.add(new JLabel("Total score : "));
		this.labelTotalScoreValue = new JLabel();
		panelResult.add(this.labelTotalScoreValue);
		
		panelResult.add(new JLabel("Total foods eated : "));
		this.labelTotalFoodEatedValue = new JLabel();
		panelResult.add(this.labelTotalFoodEatedValue);
		
		panelResult.add(new JLabel("Total enemies killed : "));
		this.labelTotalEnemyKilledValue = new JLabel();
		panelResult.add(this.labelTotalEnemyKilledValue);
		
		JPanel panelButton = new JPanel();
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonNext = new JButton("Next");
		this.buttonNext.setPreferredSize(dimension);
		this.buttonNext.addActionListener(this);
		panelButton.add(this.buttonNext);
		
		this.buttonFinish = new JButton("Finish");
		this.buttonFinish.setPreferredSize(dimension);
		this.buttonFinish.addActionListener(this);
		panelButton.add(this.buttonFinish);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		if (round.getResult() == Result.WIN) {
			this.labelMessage.setText("YOU WIN!!!");
		} else if (round.getResult() == Result.LOOSE) {
			this.labelMessage.setText("YOU LOOSE...");
			this.buttonNext.setEnabled(false);
		}

		this.labelTotalScoreValue.setText(String.valueOf(round.getRoundCumulatedStatistics().getTotalScore()));
		this.labelTotalFoodEatedValue.setText(String.valueOf(round.getRoundCumulatedStatistics().getTotalFoodEated()));
		this.labelTotalEnemyKilledValue.setText(String.valueOf(round.getRoundCumulatedStatistics().getTotalEnemyKilled()));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		dispose();
		
		if (button == this.buttonNext) {
			RoundController.openNextRound();
		} else if (button == this.buttonFinish) {
			RoundController.finishResultAndDisplayHome();
		}
	}
}
