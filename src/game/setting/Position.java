package game.setting;

import game.Model;

public class Position extends Model {

	private int x;
	private int y;
	
	public Position() {
		this.x = 0;
		this.y = 0;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
		
		notifyObservers();
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
		
		notifyObservers();
	}
}
