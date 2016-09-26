package com.sasd13.goinfromania.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.State;
import com.sasd13.goinfromania.bean.character.Pig;

public class GameView extends JPanel implements Observer {
	
	private static final int PROGRESSBAR_MIN = 0;
	private static final int PROGRESSBAR_MAX = 100;

	private ArenaView arenaView;
	private JProgressBar progressBarLife, progressBarEnergy;
	private JLabel labelState, labelScore;
	
	public GameView() {
		super(new BorderLayout());
		
		createArena();
		createPanelPig();
		createPanelGame();
	}

	private void createArena() {
		arenaView = new ArenaView();
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
		progressBarLife = new JProgressBar(PROGRESSBAR_MIN, PROGRESSBAR_MAX);
		panelLife.add(progressBarLife);
		
		panelPig.add(panelLife);
	}
	
	private void addProgressBarEnergy(JPanel panelPig) {
		JPanel panelEnergy = new JPanel();
		
		panelEnergy.add(new JLabel("Energie : "));
		progressBarEnergy = new JProgressBar(PROGRESSBAR_MIN, PROGRESSBAR_MAX);
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
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		labelScore.setText(String.valueOf(game.getScore()));
		
		Pig pig = game.getPig();
		progressBarLife.setValue(pig.getLife());
		progressBarEnergy.setValue(pig.getEnergy());
		
		if (game.getState() == State.PAUSED) {
			labelState.setText(String.valueOf(game.getState()));
		} else {
			labelState.setText("");
		}
	}
}
