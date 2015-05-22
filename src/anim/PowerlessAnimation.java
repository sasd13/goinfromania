package anim;

import game.element.character.Character;

import java.awt.event.ActionEvent;

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
			stop();
			
			this.character.setPowerful(true);
		}
	}
}
