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
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.result.GameResultController;
import com.sasd13.goinfromania.util.ViewConstants;

public class GameDialogResult extends GameDialog {

	private IFrame frame;
	private JLabel labelResult, labelScore;

	public GameDialogResult(IFrame frame, Game game) {
		super();

		this.frame = frame;

		setContentPane(new JLayeredPane());

		Dimension dimension = new Dimension(ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT);

		setSize(dimension);
		createLayers(dimension, game);
	}

	private void createLayers(Dimension dimension, Game game) {
		createLayerResult(dimension);
		createLayerScore(dimension, game);
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
		labelResult = new JLabel("", SwingConstants.HORIZONTAL);
		labelResult.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96));
		labelResult.setForeground(Color.PINK);

		panelResult.add(labelResult, BorderLayout.CENTER);
	}

	private void createLayerScore(Dimension dimension, Game game) {
		JPanel panelScore = makeNewPanel(dimension);
		panelScore.add(new JLabel("Score"), BorderLayout.NORTH);

		createLabelOfLayerScore(panelScore);
		createButtonsOfLayerScore(panelScore, game);

		getContentPane().add(panelScore, JLayeredPane.DEFAULT_LAYER);
	}

	private void createLabelOfLayerScore(JPanel panelScore) {
		labelScore = new JLabel("", SwingConstants.HORIZONTAL);

		panelScore.add(labelScore, BorderLayout.CENTER);
	}

	private void createButtonsOfLayerScore(JPanel panelScore, Game game) {
		JPanel panelButtons = new JPanel();

		addButtonsToPanelButton(panelButtons, game);

		panelScore.add(panelButtons, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButtons, Game game) {
		JButton[] buttons = { new JButton("Rejouer"), new JButton("Terminer") };

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
			button.addActionListener(new GameResultController(frame, this, game));

			panelButtons.add(button);
		}
	}

	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;

		switch (game.getResult()) {
			case WIN:
				labelResult.setText("Gagn�!!!");
				break;
			case LOOSE:
				labelResult.setText("Perdu...");
				break;
		}
		labelScore.setText(String.valueOf(game.getScore()));
	}
}
