package game.round;

import java.util.ArrayList;

public class ListRounds {

	private ArrayList<Round> list;
	
	public ListRounds() {
		this.list = new ArrayList<>();
	}
	
	public boolean add(Round round) {
		return this.list.add(round);
	}
	
	public boolean remove(Round round) {
		return this.list.remove(round);
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
}
