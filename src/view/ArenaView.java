package view;

import game.element.Element;
import game.element.ListElements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ArenaView extends JPanel implements Observer {

	private ListElements listElements;
	
	public ArenaView() {
		super();
		
		setLayout(new BorderLayout());
		Dimension dimension = new Dimension(DimensionConstants.ARENA_WIDTH, DimensionConstants.ARENA_HEIGHT);
		setPreferredSize(dimension);
		
		setBackground(Color.BLACK);
		
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
			Point position = element.getPosition();
			
			g.drawImage(element.getImage(), position.x, position.y, this);
		}
	}
}
