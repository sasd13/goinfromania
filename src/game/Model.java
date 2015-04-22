package game;

import java.util.Observable;

public abstract class Model extends Observable {

	private String title;
	
	protected Model() {
		this.title = null;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
		
		notifyObservers();
	}
}
