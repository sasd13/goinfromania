package game.element;

public abstract class Character extends Element {

	private Life life;
	
	protected Character() {
		super();
		
		setTitle("Character");
		setMovable(true);
		getSpeed().setValue(Speed.SPEED_MEDIUM);
		
		this.life = new Life();
	}
	
	public Life getLife() {
		return this.life;
	}
	
	public void setLife(Life life) {
		this.life = life;
		
		setChanged();
		notifyObservers();
	}
}
