package game.element;

import game.element.character.Pig;

import java.util.LinkedList;
import java.util.Observable;

public class ListElements extends Observable {
	
	private LinkedList<Element> list;
	
	public ListElements() {
		this.list = new LinkedList<>();
	}
	
	public void add(Element element) {
		if (element instanceof Pig) {
			if (!this.list.isEmpty() && this.list.getFirst() instanceof Pig) {
				//TODO Throw exception
			} else {
				this.list.addFirst(element);
			}
		} else {
			this.list.add(element);
		}
		
		setChanged();
		notifyObservers();
	}
	
	public void remove(Element element) {
		this.list.remove(element);
		
		setChanged();
		notifyObservers();
	}
	
	public Element get(String elementId) {
		for (Element element : this.list) {
			if (element.getId().compareTo(elementId) == 0) {
				return element;
			}
		}
		
		return null;
	}
	
	public Element get(int index) {
		return this.list.get(index);
	}
	
	public Pig getPig() {
		Pig pig = (Pig) this.list.getFirst();
		
		return pig;
	}
	
	public int size() {
		return this.list.size();
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
}
