package com.sasd13.goinfromania.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.controller.ArenaController;
import com.sasd13.goinfromania.util.ViewConstants;

public class ArenaView extends JPanel implements Observer {

	private Game game;
	
	public ArenaView() {
		super(new BorderLayout());
		
		setLayout(null);
		setPreferredSize(new Dimension(ViewConstants.ARENA_WIDTH, ViewConstants.ARENA_HEIGHT));
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new ArenaController());
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		this.game = (Game) observable;
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (this.game != null) {
			for (IElement element : this.game.getElements()) {
				//TODO g.drawImage(element.getImage(), element.getPosition().x, element.getPosition().y, this);
			}
		}
	}
}
