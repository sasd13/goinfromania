package com.sasd13.goinfromania.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.IPig;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IDialogView;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.GameConstants;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.arena.ArenaView;
import com.sasd13.goinfromania.view.dialog.GameResultDialog;
import com.sasd13.goinfromania.view.lifecycle.CycleFactory;

public class GameView extends JPanel implements IGameView {

	private FrameView frameView;
	private ArenaView arenaView;
	private JProgressBar progressBarPigLife, progressBarPigEnergy;
	private JLabel labelGameState, labelGameScore;

	public GameView(FrameView frameView, Gamepad gamepad) {
		super(new BorderLayout());

		this.frameView = frameView;

		buildView(gamepad);
	}

	private void buildView(Gamepad gamepad) {
		buildArena(gamepad);
		buildPanelPigState();
		buildPanelGameState();
	}

	private void buildArena(Gamepad gamepad) {
		arenaView = new ArenaView(gamepad);

		add(arenaView, BorderLayout.CENTER);
	}

	private void buildPanelPigState() {
		JPanel panelPigState = new JPanel(new GridLayout(1, 2));

		addProgressBarPigLife(panelPigState);
		addProgressBarPigEnergy(panelPigState);
		add(panelPigState, BorderLayout.NORTH);
	}

	private void addProgressBarPigLife(JPanel panelPigState) {
		progressBarPigLife = new JProgressBar(ViewConstants.PROGRESSBAR_MIN, ViewConstants.PROGRESSBAR_MAX);
		JPanel panelPigLife = new JPanel();

		panelPigLife.add(new JLabel("Vie : "));
		panelPigLife.add(progressBarPigLife);
		panelPigState.add(panelPigLife);
	}

	private void addProgressBarPigEnergy(JPanel panelPigState) {
		progressBarPigEnergy = new JProgressBar(ViewConstants.PROGRESSBAR_MIN, ViewConstants.PROGRESSBAR_MAX);
		JPanel panelPigEnergy = new JPanel();

		panelPigEnergy.add(new JLabel("Energie : "));
		panelPigEnergy.add(progressBarPigEnergy);
		panelPigState.add(panelPigEnergy);
	}

	private void buildPanelGameState() {
		JPanel panelGame = new JPanel(new GridLayout(1, 2));

		addLabelState(panelGame);
		addLabelScore(panelGame);
		add(panelGame, BorderLayout.SOUTH);
	}

	private void addLabelState(JPanel panelGameState) {
		labelGameState = new JLabel();
		JPanel panelState = new JPanel();

		panelState.add(labelGameState);
		panelGameState.add(panelState);
	}

	private void addLabelScore(JPanel panelGameScore) {
		labelGameScore = new JLabel();
		JPanel panelScore = new JPanel();

		panelScore.add(new JLabel("Score : "));
		panelScore.add(labelGameScore);
		panelGameScore.add(panelScore);
	}

	public void displayGame(Game game) {
		game.addObserver(this);
		arenaView.displayArena(game.getArena());
	}

	public void setPaused(boolean paused) {
		if (paused) {
			labelGameState.setText("PAUSED");
		} else {
			labelGameState.setText("");
		}
	}

	public void clear() {
		setPaused(false);
		labelGameScore.setText("");
		progressBarPigLife.setValue(GameConstants.LIFE_MIN);
		progressBarPigEnergy.setValue(GameConstants.ENERGY_MIN);
	}

	@Override
	public boolean askStop() {
		int selected = JOptionPane.showConfirmDialog(null, "Arreter la partie?", "Arrêt", JOptionPane.YES_NO_OPTION);

		return selected == JOptionPane.YES_OPTION;
	}

	@Override
	public boolean askSave() {
		int selected = JOptionPane.showConfirmDialog(null, "Sauvegarder la progression?", "Sauvegarde", JOptionPane.YES_NO_OPTION);

		return selected == JOptionPane.YES_OPTION;
	}

	@Override
	public IDialogView displayResult(Game game) {
		GameResultDialog gameResultDialog = new GameResultDialog(frameView, game);

		game.addObserver(gameResultDialog);
		gameResultDialog.update(game, null);
		gameResultDialog.pack();
		gameResultDialog.setLocationRelativeTo(this);
		gameResultDialog.setVisible(true);

		return gameResultDialog;
	}

	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;

		setValues(game);
		CycleFactory.make(game.getState().getOrder(), frameView).execute(game, this, arenaView);
	}

	private void setValues(Game game) {
		labelGameScore.setText(String.valueOf(game.getScore()));

		IPig pig = game.getArena().getPig();

		if (pig != null) {
			progressBarPigLife.setValue(game.getArena().getPig().getLife());
			progressBarPigEnergy.setValue(game.getArena().getPig().getEnergy());
		}
	}
}
