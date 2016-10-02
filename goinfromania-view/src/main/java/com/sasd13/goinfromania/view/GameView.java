package com.sasd13.goinfromania.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.ViewConstants;

public class GameView extends JPanel implements Observer, IGameView {

	private ArenaView arenaView;
	private JProgressBar progressBarPigLife, progressBarPigEnergy;
	private JLabel labelGameState, labelGameScore;
	private Game game;

	public GameView(IFrame frame) {
		super(new BorderLayout());

		buildView(frame);
	}

	private void buildView(IFrame frame) {
		buildArena(frame);
		buildPanelPigState();
		buildPanelGameState();
	}

	private void buildArena(IFrame frame) {
		arenaView = new ArenaView(frame);

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

	public ArenaView getArenaView() {
		return arenaView;
	}

	@Override
	public boolean askStop() {
		int selected = JOptionPane.showConfirmDialog(null, "Arr�ter la partie ?", "Arrêt", JOptionPane.YES_NO_OPTION);

		return selected == JOptionPane.YES_OPTION;
	}

	@Override
	public boolean askSave() {
		int selected = JOptionPane.showConfirmDialog(null, "Sauvegarder la progression ?", "Sauvegarde", JOptionPane.YES_NO_OPTION);

		return selected == JOptionPane.YES_OPTION;
	}

	@Override
	public void displayResult() {
		// TODO : display result

	}

	@Override
	public void update(Observable observable, Object arg) {
		game = (Game) observable;

		switch (game.getState()) {
			case CREATED:
				onCreate();
				break;
			case STARTED:
				onStart();
				break;
			case RESUMED:
				onResume();
				break;
			case PAUSED:
				onPause();
				break;
			case STOPPED:
				onStop();
				break;
			default:
				clear();
				break;
		}
	}

	private void onCreate() {
		// TODO : bind arena view and add observer
	}

	private void onStart() {
		setValues();
		// TODO : display starter
	}

	private void setValues() {
		labelGameScore.setText(String.valueOf(game.getScore()));
		progressBarPigLife.setValue(game.getPig().getLife());
		progressBarPigEnergy.setValue(game.getPig().getEnergy());
	}

	private void onResume() {
		labelGameState.setText("");
		setValues();
		// TODO : resume game
	}

	private void onPause() {
		labelGameState.setText("PAUSE");
		// TODO : pause game
	}

	private void onStop() {
		// TODO : display dialog stop
	}

	private void clear() {
		// TODO : display empty pane
	}
}
