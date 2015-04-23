package game.round;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import game.IViewable;
import game.element.Energy;
import game.element.EnergyView;
import game.element.Life;
import game.element.LifeView;
import game.element.Pig;

public class RoundView extends JPanel implements Observer, IViewable {

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
		this.gridView.update(grid, null);
		
		Pig pig = grid.getPig();
		
		Life life = pig.getLife();
		this.lifeView.update(life, null);
		
		Energy energy = pig.getEnergy();
		this.energyView.update(energy, null);
		
		Score score = round.getScore();
		this.scoreView.update(score, null);
	}

	@Override
	public void display() {
		setVisible(true);
	}

	@Override
	public void mask() {
		setVisible(false);
	}
}
