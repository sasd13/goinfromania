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

import com.sasd13.goinfromania.bean.Arena;
import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.ArenaController;
import com.sasd13.goinfromania.controller.IArenaView;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.arena.image.DrawableFactory;

public class ArenaView extends JPanel implements Observer, IArenaView {

	private List<IElement> elements;
	private ArenaController arenaController;

	public ArenaView(Gamepad gamepad) {
		super(new BorderLayout());

		elements = new ArrayList<>();

		buildView(gamepad);
	}

	private void buildView(Gamepad gamepad) {
		setLayout(null);
		setPreferredSize(new Dimension(ViewConstants.ARENA_WIDTH, ViewConstants.ARENA_HEIGHT));
		setBackground(Color.BLACK);
		setFocusable(true);
		buildArenaController(gamepad);
	}

	private void buildArenaController(Gamepad gamepad) {
		arenaController = new ArenaController(this, gamepad);

		addKeyListener(arenaController);
		addFocusListener(arenaController);
	}

	public void displayArena(Arena arena) {
		arena.addObserver(this);
		arenaController.setArena(arena);
	}

	public void clear() {
		elements = new ArrayList<>();

		repaint();
	}

	@Override
	public void update(Observable observable, Object arg) {
		Arena arena = (Arena) observable;

		elements = arena.getElements();

		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (IElement element : elements) {
			g.drawImage(DrawableFactory.make(element).draw(element), element.getPosition().x, element.getPosition().y, this);
		}
	}
}
