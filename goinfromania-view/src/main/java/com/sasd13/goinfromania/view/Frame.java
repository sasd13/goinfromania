package com.sasd13.goinfromania.view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.FrameController;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.GameConstants;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.menu.MenuBar;

public class Frame extends JFrame implements IFrame {

	private MenuBar menuBar;
	private JLayeredPane layersPane;
	private HomeView homeView;
	private GamesView gamesView;
	private GameView gameView;
	private FrameController frameController;

	public Frame() {
		super(GameConstants.NAME);
		
		buildView();
	}
	
	private void buildView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		buildMenuBar();
		buildLayersPane();
		buildFrameController();
	}

	private void buildMenuBar() {
		menuBar = new MenuBar(this);
		
		setJMenuBar(menuBar);
	}

	private void buildLayersPane() {
		layersPane = new JLayeredPane();
		Dimension dimension = new Dimension(ViewConstants.PANEL_WIDTH, ViewConstants.PANEL_HEIGHT);
		
		layersPane.setPreferredSize(dimension);
		addLayerHome(dimension);
		addLayerGames(dimension);
		addLayerGame(dimension);
		getContentPane().add(layersPane);
	}

	private void addLayerHome(Dimension dimension) {
		homeView = new HomeView();
		homeView.setBounds(0, 0, dimension.width, dimension.height);
		homeView.setVisible(false);
		layersPane.add(homeView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerGames(Dimension dimension) {
		gamesView = new GamesView(this);
		gamesView.setBounds(0, 0, dimension.width, dimension.height);
		gamesView.setVisible(false);
		layersPane.add(gamesView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerGame(Dimension dimension) {
		gameView = new GameView(this);
		gameView.setBounds(0, 0, dimension.width, dimension.height);
		gameView.setVisible(false);
		layersPane.add(gameView, JLayeredPane.DEFAULT_LAYER);
	}
	
	private void buildFrameController() {
		frameController = new FrameController(this);
		
		addWindowListener(frameController);
	}

	@Override
	public void displayHome() {
		homeView.setVisible(true);
		layersPane.moveToFront(homeView);
		gameView.setVisible(false);
		gamesView.setVisible(false);
		menuBar.setMenuEditEnabled(false);
	}

	@Override
	public void displayGames(List<Game> games) {
		gamesView.setGames(games);
		gamesView.setVisible(true);
		layersPane.moveToFront(gamesView);
		homeView.setVisible(false);
		gameView.setVisible(false);
		menuBar.setMenuEditEnabled(false);
	}

	@Override
	public void displayGame(Game game) {
		game.addObserver(gameView);
		frameController.setGame(game);
		gameView.setVisible(true);
		gameView.getArenaView().requestFocusInWindow();
		layersPane.moveToFront(gameView);
		homeView.setVisible(false);
		gamesView.setVisible(false);
		menuBar.setMenuEditEnabled(true);
	}

	@Override
	public IGameView getGameView() {
		return gameView;
	}

	@Override
	public void displaySetting(Setting setting) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean askClose() {
		int selected = JOptionPane.showConfirmDialog(
				null, 
				"Quitter le jeu ?", 
				"Confirmation", 
				JOptionPane.YES_NO_OPTION
		);

		return selected == JOptionPane.YES_OPTION;
	}
}
