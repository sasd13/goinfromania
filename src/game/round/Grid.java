package game.round;

import java.util.ArrayList;

import game.Model;
import game.element.Element;
import game.element.Pig;
import game.setting.Position;

public class Grid extends Model {
	
	private Pig pig;
	private static int numberElement = 0;
	private ArrayList<Element> listElement;
	
	public Grid() {
		super();
		
		setTitle("Grid");
		
		this.pig = new Pig();
		this.listElement = new ArrayList<>();
	}
	
	public Pig getPig() {
		return this.pig;
	}
	
	public void setPig(Pig pig) {
		this.pig = pig;
		
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<Element> getListElement() {
		return this.listElement;
	}
	
	public boolean putElement(Element element) {
		numberElement++;
		String id = "id-element-"+numberElement;
		element.setId(id);
		
		boolean added = this.listElement.add(element);
		
		setChanged();
		notifyObservers();
		
		return added;
	}
	
	public Element getElementAtPosition(Position position) {
		for (Element element : this.listElement) {
			if (element.getPosition().equals(position)) {
				return element;
			}
		}
		
		return null;
	}
}
