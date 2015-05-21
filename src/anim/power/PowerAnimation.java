package anim.power;

import anim.Animation;
import game.element.Element;
import game.element.power.Power;

public abstract class PowerAnimation extends Animation {

	private Power power;
	private Element elementActor, elementToAct;
	
	protected PowerAnimation(Power power, Element elementActor, Element elementToAct) {
		super();
		
		this.power = power;
		this.elementActor = elementActor;
		this.elementToAct = elementToAct;
	}
	
	public Power getPower() {
		return this.power;
	}
	
	public void setPower(Power power) {
		this.power = power;
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
