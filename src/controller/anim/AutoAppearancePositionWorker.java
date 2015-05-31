package controller.anim;

import game.element.Element;
import game.element.ListElements;

import java.awt.Point;

import javax.swing.SwingWorker;

import util.MathUtil;

public class AutoAppearancePositionWorker extends SwingWorker<Point, Point> {

	private Element element;
	private ListElements listElements;
	
	public AutoAppearancePositionWorker(Element element, ListElements listElements) {
		super();
		
		this.element = element;
		this.listElements = listElements;
	}
	
	@Override
	protected Point doInBackground() throws Exception {
		Point position = new Point();
		
		boolean isCollide = false;
		do {
			position.x = (int) (Math.random()*(Element.POSITION_X_MAX-51) + Element.POSITION_X_MIN);
			position.y = (int) (Math.random()*(Element.POSITION_Y_MAX-51) + Element.POSITION_Y_MIN);
			
			position.x = (int) MathUtil.roundDown(position.x, 50);
			position.y = (int) MathUtil.roundDown(position.y, 50);
		
			Element elementNextTo;
			for (int i=0; i<this.listElements.size(); i++) {
				elementNextTo = this.listElements.get(i);
				
				isCollide = MathUtil.isCollide(position, this.element.getDimension(), elementNextTo.getPosition(), elementNextTo.getDimension());
				
				if (isCollide) {
					break;
				}
			}
		
		} while (isCollide);
		
		return position;
	}
}