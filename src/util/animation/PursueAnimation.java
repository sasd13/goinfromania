package util.animation;

import game.element.Element;

import java.awt.event.ActionEvent;

import controller.ArenaController;

public class PursueAnimation extends Animation {

	private Element element;
	
	public PursueAnimation(Element element) {
		super();
		
		this.element = element;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count > getDuration() / getDelay()) {
			timer.stop();
		} else {
			
		}
		
		ArenaController.repaintArena();
	}
}
