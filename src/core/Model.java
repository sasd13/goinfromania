package core;

import java.util.ArrayList;

import pattern.Observable;
import pattern.Observer;

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
	public boolean addObserver(Observer view) {
		return this.listObserver.add(view);
	}
	
	@Override
	public boolean removeObserver(Observer view) {
		return this.listObserver.remove(view);
	}
	
	@Override
	public void notifyObservers() {
		for(Observer view : this.listObserver) {
			view.update(this);
		}
	}
}
