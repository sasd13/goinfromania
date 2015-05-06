package game.round.arena;

import game.element.Element;
import game.element.ListElements;
import java.util.Observable;

public class Arena extends Observable {

	
	private ListElements listElements;
	
	public Arena() {
		super();
		
		this.listElements = new ListElements();
	}
	
	public ListElements getListElements() {
		return this.listElements;
	}
	
	public void setListElements(ListElements listElements) {
		this.listElements = listElements;
		
		setChanged();
		notifyObservers();
	}
	
	public boolean addElement(Element element) {
		boolean added = this.listElements.add(element);
		
		setChanged();
		notifyObservers();
		
		return added;
	}
	
	public boolean removeElement(Element element) {
		boolean removed = this.listElements.remove(element);
		
		setChanged();
		notifyObservers();
		
		return removed;
	}
}
