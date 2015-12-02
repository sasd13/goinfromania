package main.java.view.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import main.java.view.DimensionConstants;
import main.java.view.GameView;

public class GameDialogStarter extends GameDialog implements ActionListener {

	private JLayeredPane layeredPane;
	private JPanel panelReady, panelGo;
	
	private int count;
	private Timer timer;
	
	public GameDialogStarter(GameView gameView) {
		super(gameView);
		
		this.layeredPane = new JLayeredPane();
		
		setContentPane(this.layeredPane);
		setSize(new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT));
		setBackground(Color.BLACK);
		createLayers();
	}

	private void createLayers() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96);
		
		createLayerReady(font);
		createLayerGo(font);
	}

	private void createLayerReady(Font font) {
		this.panelReady = new JPanel();
		this.panelReady.setBackground(Color.BLACK);
		this.panelReady.setBounds(0, 0, DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		
		addLabelReady(font);
		
		this.layeredPane.add(this.panelReady, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLabelReady(Font font) {
		JLabel labelReady = new JLabel("Ready !");
		labelReady.setFont(font);
		labelReady.setForeground(Color.PINK);
		
		this.panelReady.add(labelReady);
	}
	
	private void createLayerGo(Font font) {
		this.panelGo = new JPanel();
		this.panelGo.setBackground(Color.BLACK);
		this.panelGo.setBounds(0, 0, DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		
		addLabelGo(font);
		
		this.layeredPane.add(this.panelGo, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLabelGo(Font font) {
		JLabel labelGo = new JLabel("Go !");
		labelGo.setFont(font);
		labelGo.setForeground(Color.PINK);
		
		this.panelGo.add(labelGo);
	}
	
	public void display() {
		this.count = -1;
		
		setTimer();
		setLocationRelativeTo(this.gameView);
		setVisible(true);
		
		this.timer.start();
	}

	private void setTimer() {
		this.timer = new Timer(0, this);
		this.timer.setDelay(1200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.count++;
		
		if (this.count == 0) {
			displayReady();
		} else if (count == 1) {
			displayGo();
		} else {
			this.timer.stop();
			
			dispose();
		}
	}

	private void displayReady() {
		this.panelReady.setVisible(true);
		this.layeredPane.moveToFront(this.panelReady);
		
		this.panelGo.setVisible(false);
	}

	private void displayGo() {
		this.panelGo.setVisible(true);
		this.layeredPane.moveToFront(this.panelGo);
		
		this.panelReady.setVisible(false);
	}
}
