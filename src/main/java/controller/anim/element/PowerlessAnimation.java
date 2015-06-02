package main.java.controller.anim.element;

import java.awt.event.ActionEvent;

import main.java.controller.anim.Animation;
import main.java.controller.anim.AnimationHandler;
import main.java.game.element.character.Character;

public class PowerlessAnimation extends Animation {
	
	private Character character;
	
	public PowerlessAnimation(Character character) {
		super();
		
		this.character = character;
	}
	
	public Character getCharacter() {
		return this.character;
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {
			this.character.setPowerful(false);
		} else {
			this.character.setPowerful(true);
			
			AnimationHandler.finish(this);
		}
	}
}
