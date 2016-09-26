package com.sasd13.goinfromania.view.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.GameView;

public class GameDialogStarter extends GameDialog implements ActionListener {

	private JLayeredPane layeredPane;
	private JPanel panelReady, panelGo;
	
	private int count;
	private Timer timer;
	
	public GameDialogStarter(GameView gameView) {
		super(gameView);
		
		layeredPane = new JLayeredPane();
		
		setContentPane(layeredPane);
		setSize(new Dimension(ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT));
		setBackground(Color.BLACK);
		createLayers();
	}

	private void createLayers() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96);
		
		createLayerReady(font);
		createLayerGo(font);
	}

	private void createLayerReady(Font font) {
		panelReady = new JPanel();
		panelReady.setBackground(Color.BLACK);
		panelReady.setBounds(0, 0, ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT);
		
		addLabelReady(font);
		
		layeredPane.add(panelReady, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLabelReady(Font font) {
		JLabel labelReady = new JLabel("Ready !");
		labelReady.setFont(font);
		labelReady.setForeground(Color.PINK);
		
		panelReady.add(labelReady);
	}
	
	private void createLayerGo(Font font) {
		panelGo = new JPanel();
		panelGo.setBackground(Color.BLACK);
		panelGo.setBounds(0, 0, ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT);
		
		addLabelGo(font);
		
		layeredPane.add(panelGo, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLabelGo(Font font) {
		JLabel labelGo = new JLabel("Go !");
		labelGo.setFont(font);
		labelGo.setForeground(Color.PINK);
		
		panelGo.add(labelGo);
	}
	
	public void display() {
		count = -1;
		
		setTimer();
		setLocationRelativeTo(gameView);
		setVisible(true);
		
		timer.start();
	}

	private void setTimer() {
		timer = new Timer(0, this);
		timer.setDelay(1200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {
			displayReady();
		} else if (count == 1) {
			displayGo();
		} else {
			timer.stop();
			
			dispose();
		}
	}

	private void displayReady() {
		panelReady.setVisible(true);
		layeredPane.moveToFront(panelReady);
		
		panelGo.setVisible(false);
	}

	private void displayGo() {
		panelGo.setVisible(true);
		layeredPane.moveToFront(panelGo);
		
		panelReady.setVisible(false);
	}
}
