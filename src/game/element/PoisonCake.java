package game.element;

public class PoisonCake extends Cake {
	
	public PoisonCake() {
		super();
		
		setTitle("PoisonCake");
		
		setEffect(new PoisonCakeEffect());
	}
}
