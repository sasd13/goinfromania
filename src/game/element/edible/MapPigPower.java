package game.element.edible;

import game.Model;
import game.element.edible.PigPowerType;

import java.util.HashMap;

public class MapPigPower extends Model {

	private HashMap<EdibleType, Power> map;
	
	public MapPigPower() {
		super();
		
		setTitle("Pig powers");
		
		this.map = new HashMap<>();
	}
	
	public Power put(Power pigPower) {
		EdibleType pigPowerType = null;
		
		if(pigPower.getTitle().compareTo("Soporific PigPower") == 0) {
			pigPowerType = EdibleType.POWER_SOPORIFIC;
		} else if(pigPower.getTitle().compareTo("Missile PigPower") == 0) {
			pigPowerType = EdibleType.POWER_MISSILE;
		} else if(pigPower.getTitle().compareTo("SuperMissile PigPower") == 0) {
			pigPowerType = EdibleType.POWER_SUPERMISSILE;
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
	
	public Power get(PigPowerType pigPowerType) {
		return this.map.get(pigPowerType);
	}
	
	public int size() {
		return this.map.size();
	}
}
