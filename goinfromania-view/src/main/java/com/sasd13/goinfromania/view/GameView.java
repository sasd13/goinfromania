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
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.arena.ArenaView;
import com.sasd13.goinfromania.view.dialog.GameResultDialog;
import com.sasd13.goinfromania.view.dialog.GameStarterDialog;

public class GameView extends JPanel implements IGameView {

	private IFrameView frameView;
	private ArenaView arenaView;
	private JProgressBar progressBarPigLife, progressBarPigEnergy;
	private JLabel labelGameState, labelGameScore;
	private Game game;
	private GameStarterDialog gameStarterDialog;

	public GameView(IFrameView frameView) {
		super(new BorderLayout());

		this.frameView = frameView;

		buildView();
	}

	private void buildView() {
		buildArena();
		buildPanelPigState();
		buildPanelGameState();
	}

	private void buildArena() {
		arenaView = new ArenaView();

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

	public void setGamepad(Gamepad gamepad) {
		arenaView.setGamepad(gamepad);
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
		GameResultDialog gameResultDialog = new GameResultDialog(frameView, game);

		game.addObserver(gameResultDialog);
		gameResultDialog.update(game, null);
		gameResultDialog.pack();
		gameResultDialog.setLocationRelativeTo(this);
		gameResultDialog.setVisible(true);
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
		game.addObserver(arenaView);
		labelGameState.setText("");
	}

	private void onStart() {
		setValues();
		displayStarter();
	}

	private void setValues() {
		labelGameScore.setText(String.valueOf(game.getScore()));

		IPig pig = game.getPig();

		if (pig != null) {
			progressBarPigLife.setValue(pig.getLife());
			progressBarPigEnergy.setValue(pig.getEnergy());
		}
	}

	private void displayStarter() {
		if (gameStarterDialog == null) {
			gameStarterDialog = new GameStarterDialog(this);
		}

		gameStarterDialog.display();
	}

	private void onResume() {
		labelGameState.setText("");
		setValues();
		arenaView.requestFocusInWindow();
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
