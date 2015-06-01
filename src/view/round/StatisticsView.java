package view.round;

import game.round.Statistics;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticsView extends JPanel implements Observer {

	private JLabel labelCakesValue,
		labelEnemiesValue,
		labelScoreValue;
	
	public StatisticsView() {
		super(new GridLayout(1, 3));
		
		JPanel panelCakes = new JPanel();
		add(panelCakes);
		
		panelCakes.add(new JLabel("Cakes : "));
		this.labelCakesValue = new JLabel();
		panelCakes.add(this.labelCakesValue);
		
		JPanel panelEnemies = new JPanel();
		add(panelEnemies);
		
		panelEnemies.add(new JLabel("Enemies : "));
		this.labelEnemiesValue = new JLabel();
		panelEnemies.add(this.labelEnemiesValue);
		
		JPanel panelScore = new JPanel();
		add(panelScore);
		
		panelScore.add(new JLabel("Score : "));
		this.labelScoreValue = new JLabel();
		panelScore.add(this.labelScoreValue);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Statistics statistics = (Statistics) observable;
		
		this.labelCakesValue.setText(statistics.getCountEatenCakes() + "/" + statistics.getMaxCakesToEat());
		this.labelEnemiesValue.setText(String.valueOf(statistics.getCountKilledEnemies()));
		this.labelScoreValue.setText(String.valueOf(statistics.getScore()));
	}
}
