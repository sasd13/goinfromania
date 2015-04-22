package game.round;

import java.awt.BorderLayout;
import java.util.Observable;

import game.PanelView;
import game.element.Energy;
import game.element.EnergyView;
import game.element.Life;
import game.element.LifeView;
import game.element.Pig;

public class RoundView extends PanelView {

	private GridView gridView;
	private LifeView lifeView;
	private EnergyView energyView;
	private ScoreView scoreView;
	
	public RoundView() {
		super();
		
		setLayout(new BorderLayout());
		
		this.gridView = new GridView();
		add(this.gridView, BorderLayout.CENTER);
		
		this.lifeView = new LifeView();
		add(this.lifeView, BorderLayout.WEST);
		
		this.energyView = new EnergyView();
		add(this.energyView, BorderLayout.EAST);
		
		this.scoreView = new ScoreView();
		add(this.scoreView, BorderLayout.SOUTH);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		Grid grid = round.getGrid();
		Pig pig = grid.getPig();
		Life life = pig.getLife();
		Energy energy = pig.getEnergy();
		Score score = round.getScore();
		
		super.update(observable, arg);
	}
}
