package game.round;

import game.element.ListElements;
import game.element.character.Pig;

import java.util.Date;
import java.util.Observable;

public class Round extends Observable {
	
	public static final int MAX_ELEMENT = 50;
	
	private static int countRound = 0;
	private String id;
	private int roundNumber;
	private Level level;
	private ListElements listElements;
	private State state;
	private boolean finished;
	private Result result;
	private Statistics statistics;
	private Date dateCreated;
	private Date dateUpdated;
	
	public Round() {
		super();
		
		countRound++;
		this.id = "id-round-" + countRound;
		this.roundNumber = 1;
		this.level = Level.EASY;
		this.listElements = new ListElements(MAX_ELEMENT);
		this.statistics = new Statistics();
		this.state = null;
		this.finished = false;
		this.result = null;
		this.statistics = new Statistics();
		this.dateCreated = new Date(System.currentTimeMillis());
		this.dateUpdated = null;
	}
	
	public static Round createNextRound(Round round) {
		Round nextRound = new Round();
		
		nextRound.setRoundNumber(round.getRoundNumber() + 1);
		nextRound.setLevel(round.getLevel());
		nextRound.setDateCreated(round.getDateCreated());
		
		Pig pig = round.getListElements().getPig();
		Pig newPig = new Pig();
		newPig.setLife(pig.getLife());
		newPig.setEnergy(pig.getEnergy());
		nextRound.getListElements().add(newPig);
		
		Statistics statistics = round.getStatistics();
		statistics.resetCounts();
		nextRound.setStatistics(statistics);
		
		return nextRound;
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
	
	public Statistics getStatistics() {
		return this.statistics;
	}
	
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
		
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
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
		
		setChanged();
		notifyObservers();
	}
	
	public Date getDateUpdated() {
		return this.dateUpdated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
		
		setChanged();
		notifyObservers();
	}
}
