package game.round;

import game.element.ListElements;
import game.element.character.Pig;

import java.awt.Point;
import java.time.ZonedDateTime;
import java.util.Observable;

public class Round extends Observable {
	
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_EASY = 10;
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_NORMAL = 20;
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_HARD = 30;
	
	private static int countRound = 0;
	private String id;
	private int roundNumber;
	private Level level;
	private ListElements listElements;
	private int countEatenCakes;
	private int maxCountEatenCakes;
	private int countNutritionistKilled;
	private int countVirusKilled;
	private int score;
	private State state;
	private boolean finished;
	private Result result;
	private RoundStats roundStats;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	protected Round() {
		super();
		
		countRound++;
		this.id = "id-round-" + countRound;
		this.roundNumber = 0;
		this.level = Level.EASY;
		this.listElements = new ListElements();
		this.countEatenCakes = 0;
		this.maxCountEatenCakes = TOTAL_CAKE_TO_EAT_LEVEL_EASY;
		this.countNutritionistKilled = 0;
		this.countVirusKilled = 0;
		this.score = 0;
		this.state = null;
		this.finished = false;
		this.result = Result.PROGRESS;
		this.roundStats = new RoundStats();
		this.createdAt = ZonedDateTime.now();
		this.updatedAt = null;
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
		round.setCountEatenCakes(0);
		round.setCountNutritionistKilled(0);
		round.setCountVirusKilled(0);
		round.setScore(0);
		
		Pig pig = round.getListElements().getPig();
		if (resetPigPosition) {
			pig.setPosition(new Point());
		}
		
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
	
	public ListElements getListElements() {
		return this.listElements;
	}
	
	public void setListElements(ListElements listElements) {
		this.listElements = listElements;
		
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
	
	public int getMaxCountEatenCakes() {
		return this.maxCountEatenCakes;
	}
	
	public void setMaxCountEatenCakes(int maxCountEatenCakes) {
		this.maxCountEatenCakes = maxCountEatenCakes;
		
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
	
	public RoundStats getRoundStats() {
		return this.roundStats;
	}
	
	public void setRoundStats(RoundStats roundStats) {
		this.roundStats = roundStats;
		
		setChanged();
		notifyObservers();
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
