package view;

import game.element.Element;
import game.element.ListElements;
import game.element.character.Nutritionist;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.PoisonCake;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ArenaView extends JPanel implements Observer {

	private ListElements listElements;
	
	private JButton buttonPigEatCake,
		buttonPigEatPoisonCake,
		buttonNutritionistAttak,
		buttonVirusAttak;
	
	public ArenaView() {
		super();
		
		setLayout(new BorderLayout());
		Dimension dimension = new Dimension(DimensionConstants.GRID_WIDTH, DimensionConstants.GRID_HEIGHT);
		setPreferredSize(dimension);
		
		this.listElements = new ListElements();
		
		JPanel panelFoods = new JPanel();
		panelFoods.setLayout(new GridLayout(1, 2));
		
		this.buttonPigEatCake = new JButton(Cake.NAME);
		this.buttonPigEatCake.setFocusable(false);
		panelFoods.add(this.buttonPigEatCake);
		
		this.buttonPigEatPoisonCake = new JButton(PoisonCake.NAME);
		this.buttonPigEatPoisonCake.setFocusable(false);
		panelFoods.add(this.buttonPigEatPoisonCake);
		
		add(panelFoods, BorderLayout.SOUTH);
		
		JPanel panelEnemies = new JPanel();
		panelEnemies.setLayout(new GridLayout(2, 1));
		
		this.buttonNutritionistAttak = new JButton(Nutritionist.NAME);
		this.buttonNutritionistAttak.setFocusable(false);
		panelEnemies.add(this.buttonNutritionistAttak);
		
		this.buttonVirusAttak = new JButton(Virus.NAME);
		this.buttonVirusAttak.setFocusable(false);
		panelEnemies.add(this.buttonVirusAttak);
		
		add(panelEnemies, BorderLayout.EAST);
	}
	
	public JButton getButtonPigEatCake() {
		return this.buttonPigEatCake;
	}
	
	public JButton getButtonPigEatPoisonCake() {
		return this.buttonPigEatPoisonCake;
	}
	
	public JButton getButtonNutritionistAttak() {
		return this.buttonNutritionistAttak;
	}
	
	public JButton getButtonVirusAttak() {
		return this.buttonVirusAttak;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		this.listElements = (ListElements) observable;
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Element element;
		for (int i=0; i<this.listElements.size(); i++) {
			element = this.listElements.get(i);
			g.drawImage(element.getImage(), element.getPosition().x, element.getPosition().y, this);
		}
	}
}
