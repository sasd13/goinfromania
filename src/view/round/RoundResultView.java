package view.round;

import game.round.Result;
import game.round.Round;
import game.round.RoundStats;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

	public static final String BUTTON_NEXT_NAME = "Next";
	public static final String BUTTON_RESTART_NAME = "Restart";
	public static final String BUTTON_FINISH_NAME = "Finish";
	
	private JLabel labelMessage,
		labelTotalScoreValue,
		labelTotalFoodEatedValue,
		labelTotalEnemyKilledValue;
	
	private JButton buttonNext, buttonRestart, buttonFinish;
	
	public RoundResultView() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(new Dimension(DimensionConstants.ROUND_COMPONENT_WIDTH, DimensionConstants.ROUND_COMPONENT_HEIGHT));
		setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		setLayout(new BorderLayout());
		
		JPanel panelMessage = new JPanel();
		add(panelMessage, BorderLayout.NORTH);
		
		this.labelMessage = new JLabel();
		this.labelMessage.setText("Message");
		panelMessage.add(this.labelMessage);
		
		JPanel panelResult = new JPanel();
		panelResult.setLayout(new GridLayout(3, 2));
		
		JLabel labelScore = new JLabel("Total score : ");
		panelResult.add(labelScore);
		
		this.labelTotalScoreValue = new JLabel();
		panelResult.add(this.labelTotalScoreValue);
		
		JLabel labelTotalFoodEated = new JLabel("Total foods eated : ");
		panelResult.add(labelTotalFoodEated);
		
		this.labelTotalFoodEatedValue = new JLabel();
		panelResult.add(this.labelTotalFoodEatedValue);
		
		JLabel labelEnemyKilled = new JLabel("Total enemies killed : ");
		panelResult.add(labelEnemyKilled);
		
		this.labelTotalEnemyKilledValue = new JLabel();
		panelResult.add(this.labelTotalEnemyKilledValue);
		
		getContentPane().add(panelResult, BorderLayout.CENTER);
		
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout());
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		
		Dimension dimen = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonNext = new JButton(BUTTON_NEXT_NAME);
		this.buttonNext.setPreferredSize(dimen);
		this.buttonNext.addActionListener(this);
		panelButton.add(this.buttonNext);
		
		this.buttonRestart = new JButton(BUTTON_RESTART_NAME);
		this.buttonRestart.setPreferredSize(dimen);
		this.buttonRestart.addActionListener(this);
		panelButton.add(this.buttonRestart);
		
		this.buttonFinish = new JButton(BUTTON_FINISH_NAME);
		this.buttonFinish.setPreferredSize(dimen);
		this.buttonFinish.addActionListener(this);
		panelButton.add(this.buttonFinish);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		Result result = round.getResult();
		RoundStats roundStats = round.getRoundStats();
		
		switch (result) {
			case WIN :
				this.labelMessage.setText("YOU WIN!!!");
				break;
			case LOOSE:
				this.labelMessage.setText("YOU LOOSE...");
				this.buttonNext.setEnabled(false);
				break;
			default :
				break;
		}

		this.labelTotalScoreValue.setText(String.valueOf(roundStats.getTotalScore()));
		this.labelTotalFoodEatedValue.setText(String.valueOf(roundStats.getTotalFoodEated()));
		this.labelTotalEnemyKilledValue.setText(String.valueOf(roundStats.getTotalEnemyKilled()));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		GameController gameController = GameController.getInstance();
		RoundController roundController = gameController.getRoundController();
		
		dispose();
		
		if (button == this.buttonNext) {
			roundController.nextRound();
		} else if (button == this.buttonRestart) {
			roundController.restartRound();
		} else if (button == this.buttonFinish) {
			gameController.exitRound();
		} else {
			//TODO Throw exception
		}
	}
}
