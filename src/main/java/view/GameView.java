package main.java.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import main.java.bean.Game;
import main.java.bean.State;
import main.java.bean.character.pig.Pig;

public class GameView extends JPanel implements Observer {

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
		this.progressBarLife = new JProgressBar(Pig.LIFE_MIN, Pig.LIFE_MAX);
		panelLife.add(this.progressBarLife);
		
		panelPig.add(panelLife);
	}
	
	private void addProgressBarEnergy(JPanel panelPig) {
		JPanel panelEnergy = new JPanel();
		
		panelEnergy.add(new JLabel("Energie : "));
		this.progressBarEnergy = new JProgressBar(Pig.ENERGY_MIN, Pig.ENERGY_MAX);
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
		this.progressBarLife.setValue(game.getPig().getLife());
		this.progressBarEnergy.setValue(game.getPig().getEnergy());
		if (game.getState() == State.PAUSED) {
			this.labelState.setText(String.valueOf(game.getState()));
		} else {
			this.labelState.setText("");
		}
	}
}
