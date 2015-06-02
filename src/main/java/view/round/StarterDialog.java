package main.java.view.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import main.java.game.round.Round;
import main.java.view.DimensionConstants;
import main.java.view.GameView;

public class StarterDialog extends JDialog implements Observer {

	private JLayeredPane layeredPane;
	
	private JPanel panelRoundNumber, panelRoundGo;
	private JLabel labelRoundNumber;
	
	private Timer timer;
	
	public StarterDialog() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT));
		setResizable(false);
		setUndecorated(true);
		setBackground(Color.BLACK);
		
		this.layeredPane = new JLayeredPane();
		this.layeredPane.setPreferredSize(new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT));
		setContentPane(this.layeredPane);
		
		this.panelRoundNumber = new JPanel();
		this.panelRoundNumber.setBackground(Color.BLACK);
		this.panelRoundNumber.setBounds(0, 0, DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		this.layeredPane.add(this.panelRoundNumber, JLayeredPane.DEFAULT_LAYER);
		
		Font font = new Font(
				Font.SANS_SERIF,
				Font.BOLD | Font.ITALIC, 
				96);
		
		this.labelRoundNumber = new JLabel("Partie");
		this.labelRoundNumber.setFont(font);
		this.labelRoundNumber.setForeground(Color.PINK);
		this.panelRoundNumber.add(this.labelRoundNumber);
		
		this.panelRoundGo = new JPanel();
		this.panelRoundGo.setBackground(Color.BLACK);
		this.panelRoundGo.setBounds(0, 0, DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		this.layeredPane.add(this.panelRoundGo, JLayeredPane.DEFAULT_LAYER);
		
		JLabel labelRoundGo = new JLabel("Go !");
		labelRoundGo.setFont(font);
		labelRoundGo.setForeground(Color.PINK);
		this.panelRoundGo.add(labelRoundGo);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRoundNumber.setText("Partie " + round.getRoundNumber());
	}
	
	public void anime() {
		ActionListener listener = new ActionListener() {
			
			private int count = -1;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				count++;
				
				if (count == 0) {
					panelRoundNumber.setVisible(true);
					layeredPane.moveToFront(panelRoundNumber);
					panelRoundGo.setVisible(false);
				} else if (count == 1) {
					panelRoundGo.setVisible(true);
					layeredPane.moveToFront(panelRoundGo);
					panelRoundNumber.setVisible(false);
				} else {
					timer.stop();
					
					dispose();
				}
			}
		};
		
		timer = new Timer(0, listener);
		timer.setDelay(1200);
		
		setLocationRelativeTo(GameView.getInstance().getRoundView());
		
		timer.start();
		setVisible(true);
	}
}
