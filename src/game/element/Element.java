package game.element;

import game.Model;
import game.draw.Drawing;
import game.setting.Dimension;
import game.setting.Position;

public abstract class Element extends Model {

	private String id;
	private Position position;
	private Dimension dimension;
	private Drawing drawing;
	
	protected Element() {
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
	
	public Drawing getDrawing() {
		return this.drawing;
	}
	
	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
		
		setChanged();
		notifyObservers();
	}
}
