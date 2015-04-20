package game;

import java.util.ArrayList;

import patterns.Observable;
import patterns.Observer;

public abstract class Model implements Observable {

	private String title;
	private ArrayList<Observer> listObserver;
	
	protected Model() {
		this.title = null;
		this.listObserver = new ArrayList<>();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
		
		notifyObservers();
	}
	
	@Override
	public boolean addObserver(Observer observer) {
		return this.listObserver.add(observer);
	}
	
	@Override
	public boolean removeObserver(Observer observer) {
		return this.listObserver.remove(observer);
	}
	
	@Override
	public void notifyObservers() {
		for(Observer observer : this.listObserver) {
			observer.update(this);
		}
	}
}
