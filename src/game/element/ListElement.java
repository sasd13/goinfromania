package game.element;

import java.util.ArrayList;

public class ListElement {
	
	private ArrayList<Element> list;
	
	public ListElement() {
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
	
	public int size() {
		return this.list.size();
	}
}
