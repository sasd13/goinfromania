package game.round;

import java.awt.Point;
import java.util.Observable;

import game.element.Element;
import game.element.ListElement;
import game.element.character.Pig;

public class Grid extends Observable {
	
	private Pig pig;
	private ListElement listElement;
	
	public Grid() {
		super();
		
		this.pig = new Pig();
		this.listElement = new ListElement();
	}
	
	public Pig getPig() {
		return this.pig;
	}
	
	public void setPig(Pig pig) {
		this.pig = pig;
		
		setChanged();
		notifyObservers();
	}
	
	public ListElement getListElement() {
		return this.listElement;
	}
	
	public boolean addElement(Element element) {
		boolean added = this.listElement.add(element);
		
		setChanged();
		notifyObservers();
		
		return added;
	}
	
	public boolean removeElement(Element element) {
		boolean removed = this.listElement.remove(element);
		
		setChanged();
		notifyObservers();
		
		return removed;
	}
	
	public Element getElement(String elementId) {
		Element element = null;
		
		for (int i=0; i<this.listElement.size(); i++) {
			element = this.listElement.get(i);
			if (element.getId().compareTo(elementId) == 0) {
				return element;
			}
		}
		
		return null;
	}
	
	public Element getElementAtPosition(Point position) {
		Element element = null;
		
		for (int i=0; i<this.listElement.size(); i++) {
			element = this.listElement.get(i);
			if (element.getPosition().equals(position)) {
				return element;
			}
		}
		
		return null;
	}
}
