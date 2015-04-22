package game.round;

import game.Model;

import java.util.ArrayList;

public class ListRound extends Model {

	private ArrayList<Round> list;
	
	public ListRound() {
		super();
		
		setTitle("List Round");
		
		this.list = new ArrayList<>();
	}
	
	public boolean add(Round round) {
		boolean added = this.list.add(round);
		
		setChanged();
		notifyObservers();
		
		return added;
	}
	
	public boolean remove(Round round) {
		boolean removed = this.list.remove(round);
		
		setChanged();
		notifyObservers();
		
		return removed;
	}
	
	public Round get(String roundId) {
		for(Round round : this.list) {
			if(round.getId().compareTo(roundId) == 0) {
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
}
