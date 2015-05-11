package game.round;

import game.element.ListElements;
import game.element.character.Pig;

import java.time.ZonedDateTime;
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
	private ListElements listElements;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	public Round() {
		super();
		
		countRound++;
		this.id = "id-round-" + countRound;
		this.roundNumber = 0;
		this.maxPlay = MAX_PLAY;
		this.level = Level.EASY;
		this.state = null;
		this.finished = false;
		this.result = null;
		this.score = 0;
		this.createdAt = ZonedDateTime.now();
		this.updatedAt = null;
		
		this.listElements = new ListElements();
		this.listElements.add(new Pig());
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
	
	public ListElements getListElements() {
		return this.listElements;
	}
	
	public void setListElements(ListElements listElements) {
		this.listElements = listElements;
	}
	
	public ZonedDateTime getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
		
		setChanged();
		notifyObservers();
	}
	
	public ZonedDateTime getUpdatedAt() {
		return this.updatedAt;
	}
	
	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
		
		setChanged();
		notifyObservers();
	}
}
