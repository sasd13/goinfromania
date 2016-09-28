package com.sasd13.goinfromania.view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.FrameController;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.util.GameConstants;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.menu.MenuBar;

public class Frame extends JFrame implements IFrame {

	private JLayeredPane layersPane;
	private MenuBar menuBar;
	private HomeView homeView;
	private GamesView gamesView;
	private GameView gameView;

	public Frame() {
		super(GameConstants.NAME);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		createMenuBar();
		createLayersPane();
		addWindowListener(new FrameController());
	}

	private void createMenuBar() {
		menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
	}

	private void createLayersPane() {
		Dimension dimension = new Dimension(ViewConstants.PANEL_WIDTH, ViewConstants.PANEL_HEIGHT);

		layersPane = new JLayeredPane();
		layersPane.setPreferredSize(dimension);

		addLayerHome(dimension);
		addLayerListGames(dimension);
		addLayerGame(dimension);

		getContentPane().add(layersPane);
	}

	private void addLayerHome(Dimension dimension) {
		homeView = new HomeView();
		homeView.setBounds(0, 0, dimension.width, dimension.height);
		homeView.setVisible(false);
		layersPane.add(homeView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerListGames(Dimension dimension) {
		gamesView = new GamesView(this);
		gamesView.setBounds(0, 0, dimension.width, dimension.height);
		gamesView.setVisible(false);
		layersPane.add(gamesView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerGame(Dimension dimension) {
		gameView = new GameView();
		gameView.setBounds(0, 0, dimension.width, dimension.height);
		gameView.setVisible(false);
		layersPane.add(gameView, JLayeredPane.DEFAULT_LAYER);
	}

	@Override
	public void displayHome() {
		homeView.setVisible(true);
		layersPane.moveToFront(homeView);

		gameView.setVisible(false);
		gamesView.setVisible(false);

		setMenuEditEnabled(false);
	}

	private void setMenuEditEnabled(boolean enabled) {
		menuBar.setMenuEditEnabled(enabled);
	}

	@Override
	public void displayGames(List<Game> games) {
		gamesView.setVisible(true);
		layersPane.moveToFront(gamesView);

		homeView.setVisible(false);
		gameView.setVisible(false);

		setMenuEditEnabled(false);
	}

	@Override
	public void displayGame(Game game) {
		gameView.setVisible(true);
		gameView.getArenaView().requestFocusInWindow();
		layersPane.moveToFront(gameView);

		homeView.setVisible(false);
		gamesView.setVisible(false);

		setMenuEditEnabled(true);
	}
}
