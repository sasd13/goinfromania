package patern;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Observable;
import java.util.Observer;

public class ComponentController extends Controller implements ComponentListener {
	
	public ComponentController(Observable observable, Observer observer) {
		super(observable, observer);
	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		getObservable().deleteObserver(getObserver());
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
		getObserver().update(getObservable(), null);
	}
}
