package game.element.power;

import java.util.ArrayList;

public class ListPowers {

	private ArrayList<Power> list;
	
	public ListPowers() {
		this.list = new ArrayList<>();
	}
	
	public void add(Power power) {
		this.list.add(power);
	}
	
	public void remove(Power power) {
		this.list.remove(power);
	}
	
	public Power get(String powerName) {
		for (Power power : this.list) {
			if (power.getName().compareTo(powerName) == 0) {
				return power;
			}
		}
		
		return null;
	}
	
	public Power get(int index) {
		return this.list.get(index);
	}
	
	public int size() {
		return this.list.size();
	}
}
