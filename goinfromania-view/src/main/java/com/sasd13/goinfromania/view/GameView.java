package com.sasd13.goinfromania.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.ViewConstants;

public class GameView extends JPanel implements IGameView {

	private ArenaView arenaView;
	private JProgressBar progressBarLife, progressBarEnergy;
	private JLabel labelState, labelScore;

	public GameView(IFrame frame) {
		super(new BorderLayout());

		createArena(frame);
		createPanelPig();
		createPanelGame();
	}

	private void createArena(IFrame frame) {
		arenaView = new ArenaView(frame);
		add(arenaView, BorderLayout.CENTER);
	}

	private void createPanelPig() {
		JPanel panelPig = new JPanel(new GridLayout(1, 2));

		addProgressBarLife(panelPig);
		addProgressBarEnergy(panelPig);

		add(panelPig, BorderLayout.NORTH);
	}

	private void addProgressBarLife(JPanel panelPig) {
		JPanel panelLife = new JPanel();

		panelLife.add(new JLabel("Vie : "));
		progressBarLife = new JProgressBar(ViewConstants.PROGRESSBAR_MIN, ViewConstants.PROGRESSBAR_MAX);
		panelLife.add(progressBarLife);

		panelPig.add(panelLife);
	}

	private void addProgressBarEnergy(JPanel panelPig) {
		JPanel panelEnergy = new JPanel();

		panelEnergy.add(new JLabel("Energie : "));
		progressBarEnergy = new JProgressBar(ViewConstants.PROGRESSBAR_MIN, ViewConstants.PROGRESSBAR_MAX);
		panelEnergy.add(progressBarEnergy);

		panelPig.add(panelEnergy);
	}

	private void createPanelGame() {
		JPanel panelGame = new JPanel(new GridLayout(1, 2));

		addLabelState(panelGame);
		addLabelScore(panelGame);

		add(panelGame, BorderLayout.SOUTH);
	}

	private void addLabelState(JPanel panelGame) {
		JPanel panelState = new JPanel();

		labelState = new JLabel();
		panelState.add(labelState);

		panelGame.add(panelState);
	}

	private void addLabelScore(JPanel panelGame) {
		JPanel panelScore = new JPanel();

		panelScore.add(new JLabel("Score : "));
		labelScore = new JLabel();
		panelScore.add(labelScore);

		panelGame.add(panelScore);
	}

	public ArenaView getArenaView() {
		return arenaView;
	}

	@Override
	public void create(Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean askStop() {
		int selected = JOptionPane.showConfirmDialog(
				null, 
				"Arr�ter la partie ?", 
				"Arrêt", 
				JOptionPane.YES_NO_OPTION
		);
		
		return selected == JOptionPane.YES_OPTION;
	}

	@Override
	public boolean askSave() {
		int selected = JOptionPane.showConfirmDialog(
				null, 
				"Sauvegarder la progression ?", 
				"Sauvegarde", 
				JOptionPane.YES_NO_OPTION
		);

		return selected == JOptionPane.YES_OPTION;
	}

	@Override
	public void displayResult() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;

		switch (game.getState()) {
			case NONE:
				onNone(game);
				break;
			case CREATED:
				onCreate(game);
				break;
			case STARTED:
				onStart(game);
				break;
			case RESUMED:
				onResume(game);
				break;
			case PAUSED:
				onPause(game);
				break;
			case STOPPED:
				onStop(game);
				break;
			case DESTROYED:
				onDestroy(game);
				break;
		}
	}

	private void onNone(Game game) {

	}

	private void onCreate(Game game) {
		// TODO : create view
	}

	private void onStart(Game game) {
		setValues(game);
		// TODO : display starter
	}

	private void setValues(Game game) {
		labelScore.setText(String.valueOf(game.getScore()));

		Pig pig = game.getPig();

		if (pig != null) {
			progressBarLife.setValue(pig.getLife());
			progressBarEnergy.setValue(pig.getEnergy());
		}
	}

	private void onResume(Game game) {
		labelState.setText("");
		setValues(game);
		// TODO : resume game
	}

	private void onPause(Game game) {
		labelState.setText("PAUSE");
		// TODO : pause game
	}

	private void onStop(Game game) {
		// TODO : display dialog stop
	}

	private void onDestroy(Game game) {
		// TODO : display empty pane
	}
}
