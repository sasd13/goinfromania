package game.element;

import java.util.Observable;

import game.draw.Drawing;
import game.draw.IDrawable;
import game.round.PanelView;
import game.setting.Dimension;

public class ElementView extends PanelView implements IDrawable {

	public ElementView() {
		super();
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Element element = (Element) observable;
		
		Dimension dimen = element.getDimension();
		this.setPreferredSize(new java.awt.Dimension(dimen.getWidth(), dimen.getHeight()));
		
		draw(element.getDrawing());
		
		super.update(observable, arg);
	}
	
	@Override
	public void draw(Drawing drawing) {
		// TODO Auto-generated method stub
		
	}
}
