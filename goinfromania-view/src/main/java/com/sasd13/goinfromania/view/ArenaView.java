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
	private ArenaController arenaController;

	public ArenaView(IFrame frame) {
		super(new BorderLayout());

		elements = new ArrayList<>();

		buildView(frame);
	}

	private void buildView(IFrame frame) {
		setLayout(null);
		setPreferredSize(new Dimension(ViewConstants.ARENA_WIDTH, ViewConstants.ARENA_HEIGHT));
		setBackground(Color.BLACK);
		setFocusable(true);
		buildArenaController(frame);
	}

	private void buildArenaController(IFrame frame) {
		arenaController = new ArenaController(frame);

		addKeyListener(arenaController);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;

		arenaController.setGame(game);
		elements = game.getElements();

		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (IElement element : elements) {
			// TODO g.drawImage(element.getImage(), element.getPosition().x, element.getPosition().y, this);
		}
	}
}
