package game.round;

import game.Model;

public class Round extends Model {

	private static int numberRound = 0;
	private String id;
	private Grid grid;
	private Level level;
	private Score score;
	
	public Round() {
		super();
		
		setTitle("Round");
		
		numberRound++;
		this.id = "id-round-"+numberRound;
		this.grid = new Grid();
		this.level = Level.EASY;
		this.score = new Score();
	}
	
	public String getId() {
		return this.id;
	}
	
	public Grid getGrid() {
		return this.grid;
	}
	
	public void setGrid(Grid grid) {
		this.grid = grid;
		
		setChanged();
		notifyObservers();
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
		
		setChanged();
		notifyObservers();
	}
	
	public Score getScore() {
		return this.score;
	}
	
	public void setScore(Score score) {
		this.score = score;
		
		setChanged();
		notifyObservers();
	}
	
	public void start() {
		setChanged();
		notifyObservers();
	}
	
	public void resume() {
		setChanged();
		notifyObservers();
	}
	
	public void pause() {
		setChanged();
		notifyObservers();
	}
	
	public RoundResult stop() {
		RoundResult result = RoundResult.LOOSE;
		
		setChanged();
		notifyObservers();
		
		return result;
	}
}
