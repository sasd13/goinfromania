package game.round;

import java.awt.BorderLayout;
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
import game.element.character.Energy;
import game.element.character.EnergyView;
import game.element.character.Life;
import game.element.character.LifeView;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.PoisonCake;
import game.setting.DimensionConstants;

public class RoundView extends JPanel implements Observer {

	private JLabel labelRound, labelRoundId;
	private LifeView lifeView;
	private EnergyView energyView;
	private ScoreView scoreView;
	
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
		
		JPanel panelState = new JPanel();
		panelState.setLayout(new GridLayout(1, 2));
		
		JPanel panelRound = new JPanel();
		panelRound.setLayout(new FlowLayout());
		
		this.labelRound = new JLabel("Round : ");
		panelRound.add(this.labelRound);
		
		this.labelRoundId = new JLabel();
		panelRound.add(this.labelRoundId);
		
		panelState.add(panelRound);
		
		this.scoreView = new ScoreView();
		panelState.add(this.scoreView);
		
		add(panelState, BorderLayout.NORTH);
		
		JPanel panelPig = new JPanel();
		panelPig.setLayout(new GridLayout(1, 2));
		
		this.lifeView = new LifeView();
		panelPig.add(this.lifeView);
		
		this.energyView = new EnergyView();
		panelPig.add(this.energyView);
		
		add(panelPig, BorderLayout.SOUTH);
		
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
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRound.setText("Round : " + round.getId());
		
		Pig pig = round.getPig();
		draw(pig);
		
		ListElement listElement = round.getListElement();
		for(int i=0; i<listElement.size(); i++) {
			draw(listElement.get(i));
		}
		
		Life life = pig.getLife();
		life.addObserver(this.lifeView);
		this.lifeView.update(life, null);
		
		Energy energy = pig.getEnergy();
		energy.addObserver(this.energyView);
		this.energyView.update(energy, null);
		
		Score score = round.getScore();
		score.addObserver(this.scoreView);
		this.scoreView.update(score, null);
		
		RoundViewListener listener = new RoundViewListener(round, this);
		this.buttonPigAttak.addActionListener(listener);
		this.buttonPigEatCake.addActionListener(listener);
		this.buttonPigEatPoisonCake.addActionListener(listener);
		this.buttonNutritionistAttak.addActionListener(listener);
		this.buttonVirusAttak.addActionListener(listener);
		
		if (round.isFinished()) {
			RoundResult roundResult = round.stop();
			RoundLauncher.exitLiveRound(roundResult);
		}
	}
	
	private void draw(Element element) {
		// TODO Auto-generated method stub
		
	}
}
