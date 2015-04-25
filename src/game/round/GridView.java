package game.round;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.element.Element;
import game.element.ListElement;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.food.Cake;
import game.element.food.PoisonCake;

public class GridView extends JPanel implements Observer {

	public static final int GRID_WIDTH = 480;
	public static final int GRID_HEIGHT = 320;
	
	private JButton buttonPigAttak, buttonPigEatCake, buttonPigEatPoisonCake, buttonNutritionistAttak;
	
	public GridView() {
		super();
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(GRID_WIDTH, GRID_HEIGHT));
		
		this.buttonPigAttak = new JButton("Pig Attak!");
		add(this.buttonPigAttak, BorderLayout.WEST);
		
		this.buttonPigEatCake = new JButton("Eat Cake");
		add(this.buttonPigEatCake, BorderLayout.NORTH);
		
		this.buttonPigEatPoisonCake = new JButton("Eat PoisonCake");
		add(this.buttonPigEatPoisonCake, BorderLayout.SOUTH);
		
		this.buttonNutritionistAttak = new JButton("Nutritionist Attak!");
		add(this.buttonNutritionistAttak, BorderLayout.EAST);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Grid grid = (Grid) observable;
		
		final Pig pig = grid.getPig();
		draw(pig);
		
		ListElement listElement = grid.getListElement();
		for(int i=0; i<listElement.size(); i++) {
			draw(listElement.get(i));
		}
		
		if (this.buttonPigAttak.getActionListeners().length == 0) {
			this.buttonPigAttak.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Nutritionist nutritionist = new Nutritionist();
					pig.attak(nutritionist);
				}
			});
		}
		
		if (this.buttonPigEatCake.getActionListeners().length == 0) {
			this.buttonPigEatCake.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Cake cake = new Cake();
					pig.eat(cake);
				}
			});
		}
		
		if (this.buttonPigEatPoisonCake.getActionListeners().length == 0) {
			this.buttonPigEatPoisonCake.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					PoisonCake poisonCake = new PoisonCake();
					pig.eat(poisonCake);
				}
			});
		}
		
		if (this.buttonNutritionistAttak.getActionListeners().length == 0) {
			this.buttonNutritionistAttak.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Nutritionist nutritionist = new Nutritionist();
					nutritionist.attak(pig);
				}
			});
		}
	}
	
	public void draw(Element element) {
		// TODO Auto-generated method stub
		
	}
}
