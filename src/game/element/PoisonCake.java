package game.element;

public class PoisonCake extends Cake {
	
	public PoisonCake() {
		super();
		
		setEffect(new PoisonCakeEffect());
	}
}
