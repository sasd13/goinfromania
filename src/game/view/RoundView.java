package game.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.element.Element;
import game.element.ListElement;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.PoisonCake;
import game.round.Round;
import game.round.Score;

public class RoundView extends JPanel implements Observer {

	private JLabel labelRound, labelRoundValue;
	private ScoreView scoreView;
	private PigStateView pigStateView;
	
	private JPanel panelGrid, panelDraw;
	private JButton buttonPigAttak,
		buttonPigEatCake,
		buttonPigEatPoisonCake,
		buttonNutritionistAttak,
		buttonVirusAttak;
	
	public RoundView() {
		super();
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH_LARGE, DimensionConstants.FRAME_HEIGHT_LARGE));
		
		JPanel panelState = new JPanel();
		panelState.setLayout(new GridLayout(1, 2));
		
		JPanel panelRound = new JPanel();
		panelRound.setLayout(new FlowLayout());
		
		this.labelRound = new JLabel("Round : ");
		panelRound.add(this.labelRound);
		this.labelRoundValue = new JLabel();
		panelRound.add(this.labelRoundValue);
		
		panelState.add(panelRound);
		
		this.scoreView = new ScoreView();
		panelState.add(this.scoreView);
		
		add(panelState, BorderLayout.SOUTH);
		
		this.pigStateView = new PigStateView();
		add(this.pigStateView, BorderLayout.NORTH);
		
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
		
		this.panelDraw = new JPanel();
		this.panelDraw.setBackground(Color.BLACK);
		panelGrid.add(this.panelDraw, BorderLayout.CENTER);
		
		add(this.panelGrid, BorderLayout.CENTER);
	}
	
	public JPanel getPanelDraw() {
		return this.panelDraw;
	}
	
	public JButton getButtonPigAttak() {
		return this.buttonPigAttak;
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
		Round round = (Round) observable;
		
		this.labelRoundValue.setText(String.valueOf(round.getId()));
		
		Score cumulatedScore = round.getScore();
		cumulatedScore.addObserver(this.scoreView);
		this.scoreView.update(cumulatedScore, arg);
		
		Pig pig = round.getPig();
		pig.addObserver(this.pigStateView);
		this.pigStateView.update(pig, arg);
		
		draw(pig);
		
		ListElement listElement = round.getListElement();
		for(int i=0; i<listElement.size(); i++) {
			draw(listElement.get(i));
		}
	}
	
	private void draw(Element element) {
		// TODO Auto-generated method stub
		
	}
}
