package core;

import java.util.ArrayList;

import core.round.Round;
import core.round.RoundData;

public class Game extends Model {

	private static Game instance = null;
	
	public static final String NAME = "Goinfr'o'mania";
	private ArrayList<Round> listRound;
	
	private Game() {
		super();
		
		setTitle(NAME);
		
		initialize();
	}
	
	public static synchronized Game getInstance() {
		if(instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	private void initialize() {
		this.listRound = RoundData.loadRounds();
		
		if(this.listRound == null) {
			this.listRound = new ArrayList<>();
		}
		
		notifyObservers();
	}
	
	public Round newRound() {
		Round round = new Round();
		this.listRound.add(round);
		
		notifyObservers();
		
		return round;
	}
	
	public boolean removeRound(Round round) {
		boolean removed = this.listRound.remove(round);
		
		notifyObservers();
		
		return removed;
	}
	
	public Round getRound(String roundId) {
		for(Round round : this.listRound) {
			if(round.getId().compareTo(roundId) == 0) {
				return round;
			}
		}
		
		return null;
	}
	
	public void launch() {
		GameView gameView = new GameView();
		WindowController controller = new WindowController(this, gameView);
		gameView.addWindowListener(controller);
		gameView.display();
	}
	
	public void exit() {
		
	}
}
