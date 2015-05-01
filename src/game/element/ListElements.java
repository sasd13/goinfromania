package game.element;

import java.util.ArrayList;
import java.util.Observable;

public class ListElements extends Observable {
	
	private ArrayList<Element> list;
	
	public ListElements() {
		this.list = new ArrayList<>();
	}
	
	public boolean add(Element element) {
		boolean added = this.list.add(element);
		
		setChanged();
		notifyObservers();
		
		return added;
	}
	
	public boolean remove(Element element) {
		boolean removed = this.list.remove(element);
		
		setChanged();
		notifyObservers();
		
		return removed;
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
	
	public int size() {
		return this.list.size();
	}
}
