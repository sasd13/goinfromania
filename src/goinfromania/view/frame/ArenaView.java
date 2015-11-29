package goinfromania.view.frame;

import goinfromania.game.Element;
import goinfromania.game.Game;
import goinfromania.view.DimensionConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ArenaView extends JPanel implements Observer {

	private Game game;
	
	public ArenaView() {
		super(new BorderLayout());
		
		setLayout(null);
		setPreferredSize(new Dimension(DimensionConstants.ARENA_WIDTH, DimensionConstants.ARENA_HEIGHT));
		setBackground(Color.BLACK);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		this.game = (Game) observable;
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Element element : this.game.getElements()) {
			//TODO g.drawImage(element.getImage(), element.getPosition().x, element.getPosition().y, this);
		}
	}
}
