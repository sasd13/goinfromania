package util.timer;

import game.element.Element;
import game.element.ListElements;
import game.element.character.Pig;

import util.ArenaUtil;
import util.MathUtil;

import java.awt.Point;

import javax.swing.SwingWorker;

public class AppearancePositionWorker extends SwingWorker<Point, Point> {

	private Element element;
	private ListElements listElements;
	
	public AppearancePositionWorker(Element element, ListElements listElements) {
		this.element = element;
		this.listElements = listElements;
	}
	
	@Override
	protected Point doInBackground() throws Exception {
		Point position = new Point();
		
		Pig pig = this.listElements.getPig();
		
		boolean isNextTo = false;
		do {
			position.x = (int) (Math.random()*Element.POSITION_X_MAX + Element.POSITION_X_MIN);
			position.y = (int) (Math.random()*Element.POSITION_Y_MAX + Element.POSITION_Y_MIN);
			
			position.x = (int) MathUtil.roundDown(position.x, 100);
			position.y = (int) MathUtil.roundDown(position.y, 100);
		
			Element elementNextTo;
			for (int i=0; i<this.listElements.size(); i++) {
				elementNextTo = this.listElements.get(i);
				
				isNextTo = ArenaUtil.isNextTo(position, this.element.getDimension(), elementNextTo.getPosition(), elementNextTo.getDimension());
				
				if (isNextTo) {
					break;
				}
			}
		
		} while (isNextTo);
		
		this.element.setPosition(position);
		
		Element elementAtSamePosition = this.listElements.get(position);
		
		if (elementAtSamePosition == null) {
			this.listElements.add(this.element);
		}
		
		return position;
	}
}