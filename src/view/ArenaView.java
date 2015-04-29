package view;

import game.element.Element;
import game.element.ListElements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ArenaView extends JPanel implements Observer {

	private ListElements listElements;
	
	public ArenaView() {
		super();
		
		setLayout(new BorderLayout());
		Dimension dimension = new Dimension(DimensionConstants.GRID_WIDTH, DimensionConstants.GRID_HEIGHT);
		setPreferredSize(dimension);
		
		this.listElements = new ListElements();
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		this.listElements = (ListElements) observable;
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Element element;
		for (int i=0; i<this.listElements.size(); i++) {
			element = this.listElements.get(i);
			g.drawImage(element.getImage(), element.getPosition().x, element.getPosition().y, this);
		}
	}
}
