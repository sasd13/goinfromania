package game.element.power;

import java.util.HashMap;

public class MapPower {

	private HashMap<String, Power> map;
	
	public MapPower() {
		super();
		
		this.map = new HashMap<>();
	}
	
	public Power put(Power power) {
		this.map.put(power.getName(), power);
		
		return power;
	}
	
	public Power remove(Power power) {
		power = this.map.remove(power);
		
		return power;
	}
	
	public Power get(String powerName) {
		return this.map.get(powerName);
	}
	
	public int size() {
		return this.map.size();
	}
}
