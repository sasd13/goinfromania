package game.animation;

import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.util.ArenaUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RoundController;

public class MoveListener implements ActionListener {

	private RoundController roundController;
	private Element element;
	private ListElements listElements;
	
	public MoveListener(RoundController roundController, Element element, ListElements listElements) {
		this.roundController = roundController;
		this.element = element;
		this.listElements = listElements;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Direction direction = ArenaUtil.draw(this.element, this.listElements);
		System.out.println(direction.toString());
		this.roundController.actionMove(this.element, direction);
	}
}
