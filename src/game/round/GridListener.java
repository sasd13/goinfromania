package game.round;

import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.PoisonCake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.RoundController;

public class GridListener implements ActionListener {

	private RoundController roundController;
	
	public GridListener(RoundController roundController) {
		this.roundController = roundController;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		if (button.getText() == Pig.NAME) {
			Nutritionist nutritionist = new Nutritionist();
			this.roundController.pigAttakEnemy(nutritionist);
		} else if (button.getText() == Cake.NAME) {
			Cake cake = new Cake();
			this.roundController.pigEat(cake);
		} else if (button.getText() == PoisonCake.NAME) {
			PoisonCake poisonCake = new PoisonCake();
			this.roundController.pigEat(poisonCake);
		} else if (button.getText() == Nutritionist.NAME) {
			Nutritionist nutritionist = new Nutritionist();
			this.roundController.enemyAttakPig(nutritionist);
		} else if (button.getText() == Virus.NAME) {
			Virus virus = new Virus();
			this.roundController.enemyAttakPig(virus);
		} else {
			//TODO
		}
	}
}
