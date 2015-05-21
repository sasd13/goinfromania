package anim.power;

import game.element.character.Character;

import java.awt.event.ActionEvent;

import anim.Animation;

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
			timer.stop();
			
			this.character.setPowerful(true);
		}
	}
}
