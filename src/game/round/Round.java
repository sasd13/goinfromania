package game.round;

import game.element.ListElements;

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
	private int countEatenCakes;
	private int maxCountEatenCakes;
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
		this.countEatenCakes = 0;
		this.maxCountEatenCakes = TOTAL_CAKE_TO_EAT_LEVEL_EASY;
		this.state = null;
		this.finished = false;
		this.result = null;
		this.score = 0;
		this.listElements = new ListElements();
		this.createdAt = ZonedDateTime.now();
		this.updatedAt = null;
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
		
		switch (level) {
			case EASY :
				setMaxCountEatenCakes(TOTAL_CAKE_TO_EAT_LEVEL_EASY);
				break;
			case NORMAL :
				setMaxCountEatenCakes(TOTAL_CAKE_TO_EAT_LEVEL_NORMAL);
				break;
			case HARD :
				setMaxCountEatenCakes(TOTAL_CAKE_TO_EAT_LEVEL_HARD);
				break;
			default :
				//TODO Throw exception
				break;
		}
	}
	
	public int getCountEatenCakes() {
		return this.countEatenCakes;
	}
	
	public void setCountEatenCakes(int countEatenCakes) {
		this.countEatenCakes = countEatenCakes;
		
		setChanged();
		notifyObservers();
	}
	
	public int getMaxCountEatenCakes() {
		return this.maxCountEatenCakes;
	}
	
	public void setMaxCountEatenCakes(int maxCountEatenCakes) {
		this.maxCountEatenCakes = maxCountEatenCakes;
		
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
