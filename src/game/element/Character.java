package game.element;

public abstract class Character extends Element {

	private boolean alive;
	private Life life;
	
	protected Character() {
		super();
		
		setTitle("Character");
		setMovable(true);
		setSpeed(new Speed(Speed.SPEED_MEDIUM));
		
		this.life = new Life();
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
		
		setChanged();
		notifyObservers();
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
