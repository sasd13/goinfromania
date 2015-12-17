package main.java.view.round;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.game.round.Statistics;

public class StatisticsView extends JPanel implements Observer {

	private JLabel labelCakes,
		labelEnemies,
		labelScore;
	
	public StatisticsView() {
		super(new GridLayout(1, 3));
		
		JPanel panelCakes = new JPanel();
		add(panelCakes);
		
		panelCakes.add(new JLabel("Gâteaux : "));
		this.labelCakes = new JLabel();
		panelCakes.add(this.labelCakes);
		
		JPanel panelEnemies = new JPanel();
		add(panelEnemies);
		
		panelEnemies.add(new JLabel("Ennemis : "));
		this.labelEnemies = new JLabel();
		panelEnemies.add(this.labelEnemies);
		
		JPanel panelScore = new JPanel();
		add(panelScore);
		
		panelScore.add(new JLabel("Score : "));
		this.labelScore = new JLabel();
		panelScore.add(this.labelScore);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Statistics statistics = (Statistics) observable;
		
		this.labelCakes.setText(statistics.getCountEatenCakes() + "/" + statistics.getMaxCakesToEat());
		this.labelEnemies.setText(String.valueOf(statistics.getCountKilledEnemies()));
		this.labelScore.setText(String.valueOf(statistics.getScore()));
	}
}
