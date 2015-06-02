package main.java.view.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import main.java.game.element.Element;
import main.java.game.element.ListElements;
import main.java.view.DimensionConstants;

public class ArenaView extends JPanel implements Observer {

	private ListElements listElements;
	
	public ArenaView() {
		super();
		
		setLayout(null);
		setPreferredSize(new Dimension(DimensionConstants.ARENA_WIDTH, DimensionConstants.ARENA_HEIGHT));
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
			
			g.drawImage(element.getImage(), element.getPosition().x, element.getPosition().y, this);
		}
	}
}
