package patern;

import java.util.Observable;
import java.util.Observer;

public abstract class Controller {

	private Observable observable;
	private Observer observer;

	protected Controller(Observable observable, Observer observer) {
		this.observable = observable;
		this.observer = observer;
		this.observable.addObserver(this.observer);
	}
	
	public Observable getObservable() {
		return this.observable;
	}
	
	public void setObservable(Observable observable) {
		this.observable = observable;
	}
	
	public Observer getObserver() {
		return this.observer;
	}
	
	public void setObserver(Observer observer) {
		this.observer = observer;
	}
}
