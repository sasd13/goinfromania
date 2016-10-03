package com.sasd13.goinfromania.view.arena;

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
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.ArenaController;
import com.sasd13.goinfromania.controller.IArena;
import com.sasd13.goinfromania.util.ViewConstants;

public class ArenaView extends JPanel implements Observer, IArena {

	private List<IElement> elements;
	private ArenaController arenaController;

	public ArenaView() {
		super(new BorderLayout());

		elements = new ArrayList<>();

		buildView();
	}

	private void buildView() {
		setLayout(null);
		setPreferredSize(new Dimension(ViewConstants.ARENA_WIDTH, ViewConstants.ARENA_HEIGHT));
		setBackground(Color.BLACK);
		setFocusable(true);
		buildArenaController();
	}

	private void buildArenaController() {
		arenaController = new ArenaController(this);

		addKeyListener(arenaController);
	}

	public void setGamepad(Gamepad gamepad) {
		arenaController.setGamepad(gamepad);
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
			g.drawImage(ImageFinder.find(element), element.getPosition().x, element.getPosition().y, this);
		}
	}
}
