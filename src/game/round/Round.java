package game.round;

import game.element.character.Pig;
import game.round.arena.Arena;

import java.util.Observable;

public class Round extends Observable {

	public static final int MAX_PLAY = 5;
	
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_EASY = 10;
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_NORMAL = 20;
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_HARD = 30;
	
	private static int countRound = 0;
	private String id;
	private int roundNumber;
	private int maxPlay;
	private Level level;
	private State state;
	private boolean finished;
	private Result result;
	private int score;
	private Pig pig;
	private Arena arena;
	
	public Round() {
		super();
		
		countRound++;
		this.id = "id-round-" + countRound;
		this.roundNumber = 0;
		this.maxPlay = MAX_PLAY;
		this.level = Level.EASY;
		this.score = 0;
		this.pig = new Pig();
		this.arena = new Arena();
		
		this.arena.addElement(this.pig);
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getRoundNumber() {
		return this.roundNumber;
	}
	
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
		
		setChanged();
		notifyObservers();
	}
	
	public int getMaxPlay() {
		return this.maxPlay;
	}
	
	public void setMaxPlay(int maxPlay) {
		this.maxPlay = maxPlay;
		
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
	
	public State getState() {
		return this.state;
	}
	
	public void setState(State state) {
		this.state = state;
		
		setChanged();
		notifyObservers();
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
		
		setChanged();
		notifyObservers();
	}
	
	public Result getResult() {
		return this.result;
	}
	
	public void setResult(Result result) {
		this.result = result;
		
		setChanged();
		notifyObservers();
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
		
		setChanged();
		notifyObservers();
	}
	
	public Pig getPig() {
		return this.pig;
	}
	
	public void setPig(Pig pig) {
		this.pig = pig;
		
		setChanged();
		notifyObservers();
	}
	
	public Arena getArena() {
		return this.arena;
	}
	
	public void setArena(Arena arena) {
		this.arena = arena;
		
		setChanged();
		notifyObservers();
	}
}
