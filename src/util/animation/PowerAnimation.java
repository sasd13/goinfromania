package util.animation;

import game.element.Element;

public abstract class PowerAnimation extends Animation {

	private Element elementActor, elementToAct;
	
	protected PowerAnimation(Element elementActor, Element elementToAct) {
		super();
		
		this.elementActor = elementActor;
		this.elementToAct = elementToAct;
	}
	
	public Element getElementActor() {
		return this.elementActor;
	}
	
	public void setElementActor(Element elementActor) {
		this.elementActor = elementActor;
	}
	
	public Element getElementToAct() {
		return this.elementToAct;
	}
	
	public void setElementToAct(Element elementToAct) {
		this.elementToAct = elementToAct;
	}
}
