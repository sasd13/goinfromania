package com.sasd13.goinfromania.view.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameResultController;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.GameView;

public class GameDialogResult extends GameDialog {

	private JLabel labelResult, labelScore;
	
	public GameDialogResult(GameView gameView) {
		super(gameView);
		
		setContentPane(new JLayeredPane());
		
		Dimension dimension = new Dimension(ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT);
		
		setSize(dimension);
		createLayers(dimension);
	}

	private void createLayers(Dimension dimension) {
		createLayerResult(dimension);
		createLayerScore(dimension);
	}
	
	private void createLayerResult(Dimension dimension) {
		JPanel panelResult = makeNewPanel(dimension);
		
		createLabelOfLayerResult(panelResult);
		
		getContentPane().add(panelResult, JLayeredPane.DEFAULT_LAYER);
	}
	
	private JPanel makeNewPanel(Dimension dimension) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, dimension.width, dimension.height);
		
		return panel;
	}

	private void createLabelOfLayerResult(JPanel panelResult) {
		this.labelResult = new JLabel("", SwingConstants.HORIZONTAL);
		this.labelResult.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96));
		this.labelResult.setForeground(Color.PINK);
		
		panelResult.add(this.labelResult, BorderLayout.CENTER);
	}

	private void createLayerScore(Dimension dimension) {
		JPanel panelScore = makeNewPanel(dimension);
		panelScore.add(new JLabel("Score"), BorderLayout.NORTH);
		
		createLabelOfLayerScore(panelScore);
		createButtonsOfLayerScore(panelScore);
		
		getContentPane().add(panelScore, JLayeredPane.DEFAULT_LAYER);
	}

	private void createLabelOfLayerScore(JPanel panelScore) {
		this.labelScore = new JLabel("", SwingConstants.HORIZONTAL);
		
		panelScore.add(this.labelScore, BorderLayout.CENTER);
	}

	private void createButtonsOfLayerScore(JPanel panelScore) {
		JPanel panelButtons = new JPanel();
		
		addButtonsToPanelButton(panelButtons);
		
		panelScore.add(panelButtons, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButtons) {
		JButton[] buttons = {
				new JButton("Rejouer"),
				new JButton("Terminer")
		};
		
		Dimension dimensionButton = new Dimension(ViewConstants.BUTTON_WIDTH, ViewConstants.BUTTON_HEIGHT);
		String command = null;
		
		int indice = -1;
		for (JButton button : buttons) {
			indice++;
			
			switch (indice) {
				case 0:
					command = "REPLAY";
					break;
				case 1:
					command = "END";
					break;
			}
			
			button.setPreferredSize(dimensionButton);
			button.setFocusable(false);
			button.setActionCommand(command);
			button.addActionListener(new GameResultController());
			
			panelButtons.add(button);
		}
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		switch (game.getResult()) {
			case WIN:
				this.labelResult.setText("Gagn�!!!");
				break;
			case LOOSE:
				this.labelResult.setText("Perdu...");
				break;
		}
		this.labelScore.setText(String.valueOf(game.getScore()));
	}
}
