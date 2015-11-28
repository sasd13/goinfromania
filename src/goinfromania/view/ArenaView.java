package goinfromania.view;

import goinfromania.Element;
import goinfromania.Game;
import goinfromania.game.character.pig.Pig;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ArenaView extends JPanel implements Observer, KeyListener {

	private ArenaViewPanel arenaViewPanel;
	private JProgressBar progressBarLife, progressBarEnergy;
	
	public ArenaView() {
		super(new BorderLayout());
		
		this.arenaViewPanel = new ArenaViewPanel();
		add(this.arenaViewPanel, BorderLayout.CENTER);
		
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
