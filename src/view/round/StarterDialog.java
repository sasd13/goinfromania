package view.round;

import game.round.Round;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import view.DimensionConstants;
import view.GameView;

public class StarterDialog extends JDialog implements Observer {

	private JLayeredPane layeredPane;
	
	private JPanel panelRoundNumber, panelRoundGo;
	private JLabel labelRoundNumber;
	
	public StarterDialog() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT));
		setResizable(false);
		setUndecorated(true);
		setOpacity(1);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		this.layeredPane = new JLayeredPane();
		this.layeredPane.setPreferredSize(new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT));
		getContentPane().add(this.layeredPane);
		
		this.panelRoundNumber = new JPanel();
		this.panelRoundNumber.setBounds(0, 0, DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		this.layeredPane.add(this.panelRoundNumber, JLayeredPane.DEFAULT_LAYER);
		
		this.labelRoundNumber = new JLabel("Round");
		this.panelRoundNumber.add(this.labelRoundNumber);
		
		this.panelRoundGo = new JPanel();
		this.panelRoundGo.setBounds(0, 0, DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		this.layeredPane.add(this.panelRoundGo, JLayeredPane.DEFAULT_LAYER);
		
		this.panelRoundGo.add(new JLabel("Go!"));
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRoundNumber.setText("Round " + round.getRoundNumber());
	}
	
	public void anime() {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		
		final int period = 1200;
		
		Runnable runnable = new Runnable() {
			
			private int i=0;
			
			@Override
			public void run() {
				if (i == 0) {
					panelRoundNumber.setVisible(true);
					layeredPane.moveToFront(panelRoundNumber);
					panelRoundGo.setVisible(false);
					i++;
				} else if (i == 1) {
					panelRoundGo.setVisible(true);
					layeredPane.moveToFront(panelRoundGo);
					panelRoundNumber.setVisible(false);
					i++;
				} else {
					dispose();
					scheduler.shutdown();
				}
			}
		};
		
		scheduler.scheduleAtFixedRate(runnable, 0, period, TimeUnit.MILLISECONDS);
		
		setLocationRelativeTo(GameView.getInstance().getRoundView());
		setVisible(true);
	}
}
