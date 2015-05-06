package game.element;

import java.awt.Point;
import java.util.ArrayList;

public class ListElements {
	
	private ArrayList<Element> list;
	
	public ListElements() {
		this.list = new ArrayList<>();
	}
	
	public boolean add(Element element) {
		return this.list.add(element);
	}
	
	public boolean remove(Element element) {
		return this.list.remove(element);
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
	
	public Element get(Point position) {
		for (Element element : this.list) {
			if (element.getPosition().equals(position)) {
				return element;
			}
		}
		
		return null;
	}
	
	public int size() {
		return this.list.size();
	}
}
