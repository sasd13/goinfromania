package game.round;

import game.Model;

public class Round extends Model {

	private String id;
	private static int number = 0;
	
	public Round() {
		this.id = "id-round-"+number;
		number++;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void start() {
		notifyObservers();
	}
	
	public void resume() {
		notifyObservers();
	}
	
	public void save() {
		notifyObservers();
	}
	
	public void pause() {
		notifyObservers();
	}
	
	public void stop() {
		notifyObservers();
	}
}
