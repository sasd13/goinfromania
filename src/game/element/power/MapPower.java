package game.element.power;

import game.Model;

import java.util.HashMap;

public class MapPower extends Model {

	private HashMap<PowerType, Power> map;
	
	public MapPower() {
		super();
		
		setTitle("Pig powers");
		
		this.map = new HashMap<>();
	}
	
	public Power put(Power pigPower) {
		PowerType pigPowerType = null;
		
		if(pigPower.getTitle().compareTo("Soporific") == 0) {
			pigPowerType = PowerType.SOPORIFIC;
		} else if(pigPower.getTitle().compareTo("Missile") == 0) {
			pigPowerType = PowerType.MISSILE;
		} else if(pigPower.getTitle().compareTo("SuperMissile") == 0) {
			pigPowerType = PowerType.SUPERMISSILE;
		} else {
			//Throw exception
		}
		
		pigPower = this.map.put(pigPowerType, pigPower);
		
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
	
	public Power get(PowerType powerType) {
		return this.map.get(powerType);
	}
	
	public int size() {
		return this.map.size();
	}
}
