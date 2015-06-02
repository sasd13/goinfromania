package main.java.game.round;

import java.util.ArrayList;
import java.util.Observable;

public class ListRounds extends Observable {

	private ArrayList<Round> list;
	
	public ListRounds() {
		super();
		
		this.list = new ArrayList<>();
	}
	
	public void add(Round round) {
		this.list.add(round);
		
		setChanged();
		notifyObservers();
	}
	
	public void remove(Round round) {
		this.list.remove(round);
		
		setChanged();
		notifyObservers();
	}
	
	public Round get(String roundId) {
		for (Round round : this.list) {
			if (round.getId().compareTo(roundId) == 0) {
				return round;
			}
		}
		
		return null;
	}
	
	public Round get(int index) {
		return this.list.get(index);
	}
	
	public int size() {
		return this.list.size();
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
}
