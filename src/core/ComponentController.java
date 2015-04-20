package core;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import pattern.Observable;
import pattern.Observer;

public class ComponentController implements ComponentListener {
	
	private Observable observable;
	private Observer observer;

	public ComponentController(Observable observable, Observer observer) {
		this.observable = observable;
		this.observer = observer;
	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		this.observable.removeObserver(this.observer);
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		this.observable.addObserver(this.observer);
		this.observer.update(this.observable);
	}
}
