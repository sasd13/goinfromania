package core;

import java.util.ArrayList;

import core.round.Round;
import core.round.RoundData;

public class Game implements IViewable {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";
	private ArrayList<Round> listRound;
	
	private Game() {
		initialize();
	}
	
	public static synchronized Game getInstance() {
		if(instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	private void initialize() {
		this.listRound = RoundData.getRounds();
		
		if(this.listRound == null) {
			this.listRound = new ArrayList<>();
		}
	}
	
	public void exit() {
		
	}
	
	public Round newRound() {
		Round round = new Round();
		this.listRound.add(round);
		
		return round;
	}
	
	public boolean removeRound(Round round) {
		return this.listRound.remove(round);
	}
	
	public Round getRound(String roundId) {
		for(Round round : this.listRound) {
			if(round.getId().compareTo(roundId) == 0) {
				return round;
			}
		}
		
		return null;
	}
	
	@Override
	public IViewer show() {
		 GameView gameView = new GameView();
		 gameView.bind(this);
		 
		 gameView.pack();
		 gameView.setVisible(true);
		 
		 return gameView;
	}
}
