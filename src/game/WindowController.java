package game;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import patterns.Observable;
import patterns.Observer;

public class WindowController implements WindowListener {
	
	private Observable observable;
	private Observer observer;

	public WindowController(Observable observable, Observer observer) {
		this.observable = observable;
		this.observer = observer;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		this.observable.removeObserver(this.observer);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		this.observable.addObserver(this.observer);
		this.observer.update(this.observable);
	}
}
