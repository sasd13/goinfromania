package com.sasd13.goinfromania.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.controller.ArenaController;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.util.ViewConstants;

public class ArenaView extends JPanel implements Observer {

	private List<IElement> elements;
	
	public ArenaView(IFrame frame) {
		super(new BorderLayout());
		
		elements = new ArrayList<>();
		
		setLayout(null);
		setPreferredSize(new Dimension(ViewConstants.ARENA_WIDTH, ViewConstants.ARENA_HEIGHT));
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new ArenaController(frame));
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		if (game != null) {
			elements = game.getElements();
		}
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (IElement element : elements) {
			//TODO g.drawImage(element.getImage(), element.getPosition().x, element.getPosition().y, this);
		}
	}
}
