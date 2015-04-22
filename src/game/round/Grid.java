package game.round;

import java.util.ArrayList;

import game.Model;
import game.draw.GridDrawing;
import game.element.Element;
import game.element.Pig;

public class Grid extends Model {
	
	private GridDrawing drawing;
	private Pig pig;
	private static int numberElement = 0;
	private ArrayList<Element> listElement;
	
	public Grid() {
		this.pig = new Pig();
		this.listElement = new ArrayList<>();
	}
	
	public GridDrawing getDrawing() {
		return this.drawing;
	}
	
	public void setDrawing(GridDrawing drawing) {
		this.drawing = drawing;
		
		notifyObservers();
	}
	
	public Pig getPig() {
		return this.pig;
	}
	
	public void setPig(Pig pig) {
		this.pig = pig;
		
		notifyObservers();
	}
	
	public boolean putElement(Element element) {
		numberElement++;
		String id = "id-element-"+numberElement;
		element.setId(id);
		
		boolean added = this.listElement.add(element);
		
		notifyObservers();
		
		return added;
	}
}
