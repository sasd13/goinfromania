package goinfromania.view.frame;

import goinfromania.game.Element;
import goinfromania.game.Game;
import goinfromania.game.character.pig.Pig;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GameView extends JPanel implements Observer {

	private ArenaView arenaView;
	private JProgressBar progressBarLife, progressBarEnergy;
	private JLabel labelPlayer, labelScore;
	
	public GameView() {
		super(new BorderLayout());
		
		createArena();
		createPanelPig();
		createPanelPlayer();
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
	
	private void createPanelPlayer() {
		JPanel panelPlayer = new JPanel(new GridLayout(1, 2));
		
		addLabelPlayer(panelPlayer);
		addLabelScore(panelPlayer);
		
		add(panelPlayer, BorderLayout.SOUTH);
	}
	
	private void addLabelPlayer(JPanel panelPlayer) {
		panelPlayer.add(new JLabel("Joueur : "));
		this.labelPlayer = new JLabel();
		panelPlayer.add(this.labelPlayer);
	}
	
	private void addLabelScore(JPanel panelPlayer) {
		panelPlayer.add(new JLabel("Score : "));
		this.labelScore = new JLabel();
		panelPlayer.add(this.labelScore);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		this.labelPlayer.setText(game.getPlayer().getName());
		this.labelScore.setText(String.valueOf(game.getScore()));
		
		for (Element element : game.getElements()) {
			if ("PIG".equalsIgnoreCase(element.getName())) {
				this.progressBarLife.setValue(((Pig) element).getLife());
				this.progressBarEnergy.setValue(((Pig) element).getEnergy());
			}
		}
	}
}
