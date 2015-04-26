package game.round;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.element.Element;
import game.element.ListElement;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.PoisonCake;
import game.setting.DimensionConstants;

public class RoundView extends JPanel implements Observer {

	private PanelState panelState;
	private PanelPig panelPig;
	
	private JPanel panelGrid;
	private JButton buttonPigAttak,
		buttonPigEatCake,
		buttonPigEatPoisonCake,
		buttonNutritionistAttak,
		buttonVirusAttak;
	
	public RoundView() {
		super();
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH_LARGE, DimensionConstants.FRAME_HEIGHT_LARGE));
		
		this.panelPig = new PanelPig();
		add(this.panelPig, BorderLayout.NORTH);
		
		this.panelGrid = new JPanel();
		this.panelGrid.setLayout(new BorderLayout());
		this.panelGrid.setPreferredSize(new Dimension(DimensionConstants.PANEL_WIDTH_MEDIUM, DimensionConstants.PANEL_HEIGHT_MEDIUM));
		
		this.buttonPigAttak = new JButton(Pig.NAME);
		this.panelGrid.add(this.buttonPigAttak, BorderLayout.WEST);
		
		JPanel panelFoods = new JPanel();
		panelFoods.setLayout(new GridLayout(1, 2));
		
		this.buttonPigEatCake = new JButton(Cake.NAME);
		panelFoods.add(this.buttonPigEatCake);
		
		this.buttonPigEatPoisonCake = new JButton(PoisonCake.NAME);
		panelFoods.add(this.buttonPigEatPoisonCake);
		
		this.panelGrid.add(panelFoods, BorderLayout.SOUTH);
		
		JPanel panelEnemies = new JPanel();
		panelEnemies.setLayout(new GridLayout(2, 1));
		
		this.buttonNutritionistAttak = new JButton(Nutritionist.NAME);
		panelEnemies.add(this.buttonNutritionistAttak);
		
		this.buttonVirusAttak = new JButton(Virus.NAME);
		panelEnemies.add(this.buttonVirusAttak);
		
		this.panelGrid.add(panelEnemies, BorderLayout.EAST);
		
		add(this.panelGrid, BorderLayout.CENTER);
		
		this.panelState = new PanelState();
		add(this.panelState, BorderLayout.SOUTH);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.panelState.update(round, arg);
		
		Pig pig = round.getPig();
		pig.addObserver(this.panelPig);
		this.panelPig.update(pig, arg);
		
		draw(pig);
		
		ListElement listElement = round.getListElement();
		for(int i=0; i<listElement.size(); i++) {
			draw(listElement.get(i));
		}
		
		RoundViewListener listener = new RoundViewListener(round, this);
		this.buttonPigAttak.addActionListener(listener);
		this.buttonPigEatCake.addActionListener(listener);
		this.buttonPigEatPoisonCake.addActionListener(listener);
		this.buttonNutritionistAttak.addActionListener(listener);
		this.buttonVirusAttak.addActionListener(listener);
	}
	
	private void draw(Element element) {
		// TODO Auto-generated method stub
		
	}
}
