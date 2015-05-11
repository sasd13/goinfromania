package view;

import game.round.Result;
import game.round.Round;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import controller.GameController;
import controller.RoundController;

public class RoundResultView extends JDialog implements Observer, ActionListener {

	public static final String BUTTON_NEXT_NAME = "Next";
	public static final String BUTTON_RESTART_NAME = "Restart";
	public static final String BUTTON_FINISH_NAME = "Finish";
	
	private JLabel labelTitle,
		labelMessage,
		labelScore;
	
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
		
		JPanel panelResult = new JPanel();
		panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.PAGE_AXIS));
		panelResult.setAlignmentX(CENTER_ALIGNMENT);
		
		this.labelTitle = new JLabel();
		this.labelTitle.setText("Text");
		panelResult.add(this.labelTitle);
		
		this.labelMessage = new JLabel();
		this.labelMessage.setText("Message");
		panelResult.add(this.labelMessage);
		
		this.labelScore = new JLabel();
		this.labelScore.setText("Score");
		panelResult.add(this.labelScore);
		
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
		
		if (result != null) {
			switch (result) {
				case WIN:
					this.labelTitle.setText("YOU WIN!!!");
					this.labelMessage.setText("Continue ?");
					break;
				case LOOSE:
					this.labelTitle.setText("YOU LOOSE...");
					this.labelMessage.setText("Restart ?");
					this.buttonNext.setEnabled(false);
					break;
			}
		
			this.labelScore.setText("Score : " + round.getScore());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		GameController gameController = GameController.getInstance();
		RoundController roundController = gameController.getRoundController();
		
		if (button == this.buttonNext) {
			roundController.nextRound();
		} else if (button == this.buttonRestart) {
			roundController.restartRound();
		} else if (button == this.buttonFinish) {
			gameController.displayHome();
		} else {
			//TODO Throw exception
		}
		
		dispose();
	}
}
