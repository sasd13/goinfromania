package game.element.power;

import java.util.HashMap;
import java.util.Observable;

public class MapPower extends Observable {

	private HashMap<String, Power> map;
	
	public MapPower() {
		super();
		
		this.map = new HashMap<>();
	}
	
	public Power put(Power pigPower) {
		this.map.put(pigPower.getName(), pigPower);
		
		setChanged();
		notifyObservers();
		
		return pigPower;
	}
	
	public Power remove(Power pigPower) {
		pigPower = this.map.remove(pigPower);
		
		setChanged();
		notifyObservers();
		
		return pigPower;
	}
	
	public Power get(String powerName) {
		return this.map.get(powerName);
	}
	
	public int size() {
		return this.map.size();
	}
}
