package game.element;

import game.Model;
import game.draw.ElementDrawing;
import game.setting.Dimension;
import game.setting.Position;

public abstract class Element extends Model {

	private String id;
	private Position position;
	private Dimension dimension;
	private ElementDrawing drawing;
	
	public Element() {
		super();
		
		setTitle("Element");
		
		this.position = new Position();
		this.dimension = new Dimension();
		this.drawing = null;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
		
		setChanged();
		notifyObservers();
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
		
		setChanged();
		notifyObservers();
	}
	
	public Dimension getDimension() {
		return this.dimension;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
		
		setChanged();
		notifyObservers();
	}
	
	public ElementDrawing getDrawing() {
		return this.drawing;
	}
	
	public void setDrawing(ElementDrawing drawing) {
		this.drawing = drawing;
		
		setChanged();
		notifyObservers();
	}
}
