package com.sasd13.goinfromania.view.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IDialogView;
import com.sasd13.goinfromania.controller.result.EnumGameResultAction;
import com.sasd13.goinfromania.controller.result.GameResultController;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.FrameView;

public class GameResultDialog extends JDialog implements Observer, IDialogView {

	private JLabel labelResult, labelScore;

	public GameResultDialog(FrameView frameView, Game game) {
		super();

		buildView(frameView, game);
	}

	private void buildView(FrameView frameView, Game game) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setUndecorated(true);
		setContentPane(new JLayeredPane());

		Dimension dimension = new Dimension(ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT);

		setSize(dimension);
		buildLayers(dimension, frameView, game);
	}

	private void buildLayers(Dimension dimension, FrameView frameView, Game game) {
		buildLayerResult(dimension);
		buildLayerScore(dimension, frameView, game);
	}

	private void buildLayerResult(Dimension dimension) {
		JPanel panelResult = makeNewPanel(dimension);

		buildLabelResult(panelResult);
		getContentPane().add(panelResult, JLayeredPane.DEFAULT_LAYER);
	}

	private JPanel makeNewPanel(Dimension dimension) {
		JPanel panel = new JPanel(new BorderLayout());

		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, dimension.width, dimension.height);

		return panel;
	}

	private void buildLabelResult(JPanel panelResult) {
		labelResult = new JLabel("", SwingConstants.HORIZONTAL);

		labelResult.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96));
		labelResult.setForeground(Color.PINK);
		panelResult.add(labelResult, BorderLayout.CENTER);
	}

	private void buildLayerScore(Dimension dimension, FrameView frameView, Game game) {
		JPanel panelScore = makeNewPanel(dimension);

		panelScore.add(new JLabel("Score"), BorderLayout.NORTH);
		buildLabelScore(panelScore);
		buildButtonsOfLayerScore(panelScore, frameView, game);
		getContentPane().add(panelScore, JLayeredPane.DEFAULT_LAYER);
	}

	private void buildLabelScore(JPanel panelScore) {
		labelScore = new JLabel("", SwingConstants.HORIZONTAL);

		panelScore.add(labelScore, BorderLayout.CENTER);
	}

	private void buildButtonsOfLayerScore(JPanel panelScore, FrameView frameView, Game game) {
		JPanel panelButtons = new JPanel();

		addButtonsToPanelButton(panelButtons, frameView, game);
		panelScore.add(panelButtons, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButtons, FrameView frameView, Game game) {
		Dimension dimensionButton = new Dimension(ViewConstants.BUTTON_WIDTH, ViewConstants.BUTTON_HEIGHT);
		GameResultController gameResultController = new GameResultController(frameView, this, game);

		addButtonReplay(panelButtons, dimensionButton, gameResultController);
		addButtonFinish(panelButtons, dimensionButton, gameResultController);
	}

	private void addButtonReplay(JPanel panelButtons, Dimension dimensionButton, GameResultController gameResultController) {
		JButton buttonReplay = new JButton("Rejouer");

		buttonReplay.setPreferredSize(dimensionButton);
		buttonReplay.setFocusable(false);
		buttonReplay.setActionCommand(EnumGameResultAction.REPLAY.getCode());
		buttonReplay.addActionListener(gameResultController);
		panelButtons.add(buttonReplay);
	}

	private void addButtonFinish(JPanel panelButtons, Dimension dimensionButton, GameResultController gameResultController) {
		JButton buttonFinish = new JButton("Terminer");

		buttonFinish.setPreferredSize(dimensionButton);
		buttonFinish.setFocusable(false);
		buttonFinish.setActionCommand(EnumGameResultAction.FINISH.getCode());
		buttonFinish.addActionListener(gameResultController);
		panelButtons.add(buttonFinish);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;

		switch (game.getResult()) {
			case WIN:
				labelResult.setText("Gagne!!!");
				break;
			case LOOSE:
				labelResult.setText("Perdu...");
				break;
			default:
				break;
		}

		labelScore.setText(String.valueOf(game.getScore()));
	}
}
