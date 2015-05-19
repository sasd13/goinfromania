package game.element;

import game.element.character.Pig;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

public class ListElements extends Observable {
	
	private ArrayList<Element> list;
	
	public ListElements() {
		this.list = new ArrayList<>();
	}
	
	public ListElements(int size) {
		this.list = new ArrayList<>(size);
	}
	
	public void add(Element element) {
		this.list.add(element);
		
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
	
	public Element get(Point position) {
		for (Element element : this.list) {
			if (element.getPosition().equals(position)) {
				return element;
			}
		}
		
		return null;
	}
	
	public Element get(int index) {
		return this.list.get(index);
	}
	
	public Pig getPig() {
		return (Pig) this.list.get(0);
	}
	
	public int size() {
		return this.list.size();
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
}
