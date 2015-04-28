package game.element.power;

import java.util.HashMap;

public class MapPower {

	private HashMap<String, Power> map;
	
	public MapPower() {
		this.map = new HashMap<>();
	}
	
	public Power put(Power power) {
		return this.map.put(power.getName(), power);
	}
	
	public Power remove(Power power) {
		return this.map.remove(power);
	}
	
	public Power get(String powerName) {
		return this.map.get(powerName);
	}
	
	public int size() {
		return this.map.size();
	}
}
