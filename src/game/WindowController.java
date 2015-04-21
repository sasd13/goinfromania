package game;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import patterns.Observable;
import patterns.Observer;

public class WindowController extends Controller implements WindowListener {
	
	public WindowController(Observable observable, Observer observer) {
		super(observable, observer);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		getObservable().removeObserver(getObserver());
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
		getObserver().update(getObservable());
	}
}
