package game.round;

import game.Model;

public class Round extends Model {

	private static int numberRound = 0;
	private String id;
	private Grid grid;
	private Level level;
	private Score score;
	
	public Round() {
		numberRound++;
		this.id = "id-round-"+numberRound;
		this.level = Level.EASY;
		this.grid = new Grid();
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
		
		notifyObservers();
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
		
		notifyObservers();
	}
	
	public Score getScore() {
		return this.score;
	}
	
	public void setScore(Score score) {
		this.score = score;
		
		notifyObservers();
	}
	
	public void start() {
		notifyObservers();
	}
	
	public void resume() {
		notifyObservers();
	}
	
	public void pause() {
		notifyObservers();
	}
	
	public RoundResult stop() {
		RoundResult result = RoundResult.LOOSE;
		
		notifyObservers();
		
		return result;
	}
}
