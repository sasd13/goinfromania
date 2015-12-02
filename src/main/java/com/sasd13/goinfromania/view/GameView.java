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
import com.sasd13.goinfromania.bean.character.pig.Pig;
import com.sasd13.goinfromania.engine.PigEngine;

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
		this.arenaView = new ArenaView();
		add(this.arenaView, BorderLayout.CENTER);
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
		this.progressBarLife = new JProgressBar(PROGRESSBAR_MIN, PROGRESSBAR_MAX);
		panelLife.add(this.progressBarLife);
		
		panelPig.add(panelLife);
	}
	
	private void addProgressBarEnergy(JPanel panelPig) {
		JPanel panelEnergy = new JPanel();
		
		panelEnergy.add(new JLabel("Energie : "));
		this.progressBarEnergy = new JProgressBar(PROGRESSBAR_MIN, PROGRESSBAR_MAX);
		panelEnergy.add(this.progressBarEnergy);
		
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
		
		this.labelState = new JLabel();
		panelState.add(this.labelState);
		
		panelGame.add(panelState);
	}
	
	private void addLabelScore(JPanel panelGame) {
		JPanel panelScore = new JPanel();
		
		panelScore.add(new JLabel("Score : "));
		this.labelScore = new JLabel();
		panelScore.add(this.labelScore);
		
		panelGame.add(panelScore);
	}
	
	public ArenaView getArenaView() {
		return arenaView;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		this.labelScore.setText(String.valueOf(game.getScore()));
		
		Pig pig = PigEngine.findPig(game.getElements());
		this.progressBarLife.setValue(pig.getLife());
		this.progressBarEnergy.setValue(pig.getEnergy());
		
		if (game.getState() == State.PAUSED) {
			this.labelState.setText(String.valueOf(game.getState()));
		} else {
			this.labelState.setText("");
		}
	}
}
