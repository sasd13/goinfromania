package game.params;

import game.round.RoundParams;

public class ParamsManager {

	public static Params load(ParamsType paramsType) {
		switch (paramsType) {
			case KEYBOARD : 
				return new KeyboardParams();
			case ROUND :
				return new RoundParams();
			default :
				return null;
		}
	}
	
	public static void save(Params params) {
		
	}
}
