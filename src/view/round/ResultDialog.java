package view.round;

import game.round.Result;
import game.round.Round;
import game.round.Statistics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import view.DimensionConstants;
import view.GameView;
import controller.RoundController;

public class ResultDialog extends JDialog implements Observer, ActionListener {

	private JLayeredPane layeredPane;
	
	private JPanel panelResult, panelStatistics;
	
	private JLabel labelResult,
		labelScore,
		labelTotalFoodEated,
		labelTotalEnemyKilled;
	
	private JButton buttonNext, buttonFinish;
	
	private Timer timer;
	
	public ResultDialog() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setUndecorated(true);
		
		Dimension dimension = new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		setSize(dimension);
		
		this.layeredPane = new JLayeredPane();
		setContentPane(this.layeredPane);
		
		this.panelResult = new JPanel(new BorderLayout());
		this.panelResult.setBackground(Color.BLACK);
		this.panelResult.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.panelResult, JLayeredPane.DEFAULT_LAYER);
		
		Font font = new Font(
				Font.SANS_SERIF,
				Font.BOLD | Font.ITALIC, 
				96);
		
		this.labelResult = new JLabel("", SwingConstants.HORIZONTAL);
		this.labelResult.setFont(font);
		this.labelResult.setForeground(Color.PINK);
		this.panelResult.add(this.labelResult, BorderLayout.CENTER);
		
		this.panelStatistics = new JPanel(new BorderLayout());
		this.panelStatistics.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.panelStatistics, JLayeredPane.DEFAULT_LAYER);
		
		JLabel labelStatistics = new JLabel("Statistiques", SwingConstants.HORIZONTAL);
		this.panelStatistics.add(labelStatistics, BorderLayout.NORTH);
		
		JPanel panelTotals = new JPanel(new GridLayout(3, 2));
		this.panelStatistics.add(panelTotals, BorderLayout.CENTER);
		
		panelTotals.add(new JLabel("Score : "));
		this.labelScore = new JLabel();
		panelTotals.add(this.labelScore);
		
		panelTotals.add(new JLabel("Total gâteaux mangés : "));
		this.labelTotalFoodEated = new JLabel();
		panelTotals.add(this.labelTotalFoodEated);
		
		panelTotals.add(new JLabel("Total ennemis éliminés : "));
		this.labelTotalEnemyKilled = new JLabel();
		panelTotals.add(this.labelTotalEnemyKilled);
		
		JPanel panelButton = new JPanel();
		this.panelStatistics.add(panelButton, BorderLayout.SOUTH);
		
		Dimension dimensionButton = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonNext = new JButton("Suivant");
		this.buttonNext.setPreferredSize(dimensionButton);
		this.buttonNext.setFocusable(false);
		this.buttonNext.addActionListener(this);
		panelButton.add(this.buttonNext);
		
		this.buttonFinish = new JButton("Terminer");
		this.buttonFinish.setPreferredSize(dimensionButton);
		this.buttonFinish.setFocusable(false);
		this.buttonFinish.addActionListener(this);
		panelButton.add(this.buttonFinish);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		if (round.getResult() == Result.WIN) {
			this.labelResult.setText("Gagné!!!");
			this.buttonNext.setEnabled(true);
		} else if (round.getResult() == Result.LOOSE) {
			this.labelResult.setText("Perdu...");
			this.buttonNext.setEnabled(false);
		}

		Statistics statistics = round.getStatistics();
		this.labelScore.setText(String.valueOf(statistics.getScore()));
		this.labelTotalFoodEated.setText(String.valueOf(statistics.getTotalFoodEated()));
		this.labelTotalEnemyKilled.setText(String.valueOf(statistics.getTotalEnemyKilled()));
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
	
	public void anime() {
		ActionListener listener = new ActionListener() {
			
			private int count = -1;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				count++;
				
				if (count == 0) {
					panelResult.setVisible(true);
					layeredPane.moveToFront(panelResult);
					panelStatistics.setVisible(false);
				} else {
					timer.stop();
					
					panelStatistics.setVisible(true);
					layeredPane.moveToFront(panelStatistics);
					panelResult.setVisible(false);
				}
			}
		};
		
		timer = new Timer(0, listener);
		timer.setDelay(1700);
		
		setLocationRelativeTo(GameView.getInstance().getRoundView());
		
		timer.start();
		setVisible(true);
	}
}
