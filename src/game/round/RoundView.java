package game.round;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.element.character.Energy;
import game.element.character.EnergyView;
import game.element.character.Life;
import game.element.character.LifeView;
import game.element.character.Pig;
import game.setting.DimensConst;

public class RoundView extends JPanel implements Observer {

	private JLabel labelRound, labelRoundId;
	private GridView gridView;
	private LifeView lifeView;
	private EnergyView energyView;
	private ScoreView scoreView;
	
	public RoundView() {
		super();
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(DimensConst.FRAME_WIDTH_LARGE, DimensConst.FRAME_HEIGHT_LARGE));
		
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
		
		this.gridView = new GridView();
		add(this.gridView, BorderLayout.CENTER);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRound.setText("Round : " + round.getId());
		
		Grid grid = round.getGrid();
		if (grid.countObservers() == 0) {
			grid.addObserver(this.gridView);
			this.gridView.update(grid, null);
		}
		
		Pig pig = grid.getPig();
		
		Life life = pig.getLife();
		if (life.countObservers() == 0) {
			life.addObserver(this.lifeView);
			this.lifeView.update(life, null);
		}
		
		Energy energy = pig.getEnergy();
		if (energy.countObservers() == 0) {
			energy.addObserver(this.energyView);
			this.energyView.update(energy, null);
		}
		
		Score score = round.getScore();
		if (score.countObservers() == 0) {
			score.addObserver(this.scoreView);
			this.scoreView.update(score, null);
		}
	}
}
