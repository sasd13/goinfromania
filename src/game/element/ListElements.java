package game.element;

import game.element.character.Pig;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Observable;

public class ListElements extends Observable {
	
	private static int size = 0;
	public static final int MAX_SIZE = 20;
	
	private LinkedList<Element> list;
	
	public ListElements() {
		this.list = new LinkedList<>();
	}
	
	public void add(Element element) {
		if (size < MAX_SIZE) {
			if (element instanceof Pig) {
				if (!this.list.isEmpty() && this.list.getFirst() instanceof Pig) {
					//TODO Throw exception
				} else {
					this.list.addFirst(element);
					size++;
				}
			} else {
				this.list.add(element);
				size++;
			}
			
			setChanged();
			notifyObservers();
		}
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
		return (Pig) this.list.getFirst();
	}
	
	public int size() {
		return this.list.size();
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
}
