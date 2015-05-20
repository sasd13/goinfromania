package game.round;

import game.element.ListElements;
import game.element.character.Pig;

import java.awt.Point;
import java.util.Date;
import java.util.Observable;

public class Round extends Observable {
	
	public static final int INCREMENTAL_CAKE_TO_EAT = 3;
	public final int MAX_ELEMENT = 50;
	
	private static int countRound = 0;
	private String id;
	private int roundNumber;
	private Level level;
	private ListElements listElements;
	private int maxCountEatenCakes;
	private int countEatenCakes;
	private int countEatenPoisonCakes;
	private int countNutritionistKilled;
	private int countVirusKilled;
	private int score;
	private State state;
	private boolean finished;
	private Result result;
	private RoundCumulatedStatistics roundCumulatedStatistics;
	private Date createdAt;
	private Date updatedAt;
	
	protected Round() {
		super();
		
		countRound++;
		this.id = "id-round-" + countRound;
		this.roundNumber = 0;
		this.level = Level.EASY;
		this.listElements = new ListElements(MAX_ELEMENT);
		this.maxCountEatenCakes = INCREMENTAL_CAKE_TO_EAT;
		this.state = null;
		this.finished = false;
		this.result = Result.PROGRESS;
		this.roundCumulatedStatistics = new RoundCumulatedStatistics();
		this.createdAt = new Date(System.currentTimeMillis());
		this.updatedAt = null;
		
		resetStatistics();
	}
	
	public static Round getNewInstance() {
		Round round = new Round();
		round.setRoundNumber(1);
		
		Pig pig = new Pig();
		round.getListElements().add(pig);
		
		return round;
	}
	
	public static Round createNextRound(Round round, boolean nextLevel, boolean resetPigPosition) {
		round.setFinished(false);
		
		Level level = round.getLevel();
		
		if (nextLevel) {
			switch (level) {
				case EASY :
					round.setLevel(Level.NORMAL);
					break;
				case NORMAL : case HARD :
					round.setLevel(Level.HARD);
					break;
				default :
					//TODO Throw exception
					break;
			}
		}
		
		round.setRoundNumber(round.getRoundNumber() + 1);
		round.setMaxCountEatenCakes(round.getMaxCountEatenCakes() + INCREMENTAL_CAKE_TO_EAT);
		round.resetStatistics();
		
		Pig pig = round.getListElements().getPig();
		if (resetPigPosition) {
			pig.setPosition(new Point());
		}
		
		ListElements listElements = new ListElements();
		listElements.add(pig);
		
		round.setListElements(listElements);
		
		return round;
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
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
		
		setChanged();
		notifyObservers();
	}
	
	public ListElements getListElements() {
		return this.listElements;
	}
	
	public void setListElements(ListElements listElements) {
		this.listElements = listElements;
		
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
	
	public int getCountEatenCakes() {
		return this.countEatenCakes;
	}
	
	public void setCountEatenCakes(int countEatenCakes) {
		this.countEatenCakes = countEatenCakes;
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountEatenPoisonCakes() {
		return this.countEatenPoisonCakes;
	}
	
	public void setCountEatenPoisonCakes(int countEatenPoisonCakes) {
		this.countEatenPoisonCakes = countEatenPoisonCakes;
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountNutritionistKilled() {
		return this.countNutritionistKilled;
	}
	
	public void setCountNutritionistKilled(int countNutritionistKilled) {
		this.countNutritionistKilled = countNutritionistKilled;
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountVirusKilled() {
		return this.countVirusKilled;
	}
	
	public void setCountVirusKilled(int countVirusKilled) {
		this.countVirusKilled = countVirusKilled;
		
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
	
	public RoundCumulatedStatistics getRoundCumulatedStatistics() {
		return this.roundCumulatedStatistics;
	}
	
	public void setRoundCumulatedStatistics(RoundCumulatedStatistics roundCumulatedStatistics) {
		this.roundCumulatedStatistics = roundCumulatedStatistics;
		
		setChanged();
		notifyObservers();
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		
		setChanged();
		notifyObservers();
	}
	
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		
		setChanged();
		notifyObservers();
	}
	
	public int getFoodEated() {
		return this.countEatenCakes + this.countEatenPoisonCakes;
	}
	
	public int getCountEnemyKilled() {
		return this.countNutritionistKilled + this.countVirusKilled;
	}
	
	public void resetStatistics() {
		setCountEatenCakes(0);
		setCountEatenPoisonCakes(0);
		setCountNutritionistKilled(0);
		setCountVirusKilled(0);
		setScore(0);
	}
}
