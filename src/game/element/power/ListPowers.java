package game.element.power;

import java.util.ArrayList;

public class ListPowers {

	private ArrayList<Power> list;
	
	public ListPowers() {
		this.list = new ArrayList<>();
	}
	
	public boolean add(Power power) {
		return this.list.add(power);
	}
	
	public boolean remove(Power power) {
		return this.list.remove(power);
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
