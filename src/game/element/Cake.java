package game.element;

public class Cake extends Edible {

	public Cake() {
		super();
		
		setTitle("Cake");
		
		setEffect(new CakeEffect());
	}
}
