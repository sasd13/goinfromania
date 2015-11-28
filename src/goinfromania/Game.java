package goinfromania;

import java.sql.Timestamp;
import java.util.List;

public class Game {
	
	public static final String NAME = "Goinfr'o'mania";

	private State state;
	private Level level;
	private Result result;
	private int score;
	private Timestamp dateCreation, dateLastUpdate;
	private Player player;
	private List<Element> elements;
	
	public Game() {}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timestamp getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Timestamp getDateLastUpdate() {
		return dateLastUpdate;
	}

	public void setDateLastUpdate(Timestamp dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void addElement(Element element) {
		this.elements.add(element);
	}
	
	public void removeElement(Element element) {
		this.elements.remove(element);
	}
	
	public Element[] getElements() {
		return this.elements.toArray(new Element[this.elements.size()]);
	}
}
