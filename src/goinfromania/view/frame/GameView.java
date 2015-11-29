package goinfromania.view.frame;

import goinfromania.game.Element;
import goinfromania.game.Game;
import goinfromania.game.character.pig.Pig;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GameView extends JPanel implements Observer, KeyListener {

	private ArenaView arenaView;
	private JProgressBar progressBarLife, progressBarEnergy;
	
	public GameView() {
		super(new BorderLayout());
		
		this.arenaView = new ArenaView();
		add(this.arenaView, BorderLayout.CENTER);
		
		JPanel panelPig = new JPanel();
		add(panelPig, BorderLayout.NORTH);
		
		JPanel panelLife = new JPanel();
		panelPig.add(panelLife);
		
		panelLife.add(new JLabel("Vie : "));
		this.progressBarLife = new JProgressBar(Pig.LIFE_MIN, Pig.LIFE_MAX);
		panelLife.add(this.progressBarLife);
		
		JPanel panelEnergy = new JPanel();
		panelPig.add(panelEnergy);
		
		panelEnergy.add(new JLabel("Energie : "));
		this.progressBarEnergy = new JProgressBar(Pig.ENERGY_MIN, Pig.ENERGY_MAX);
		panelEnergy.add(this.progressBarEnergy);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		for (Element element : game.getElements()) {
			if ("PIG".equalsIgnoreCase(element.getClass().getSimpleName())) {
				Pig pig = (Pig) element;
				
				this.progressBarLife.setValue(pig.getLife());
				this.progressBarEnergy.setValue(pig.getEnergy());
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//Do nothing
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//TODO
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//TODO
	}
}
