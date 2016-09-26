package com.sasd13.goinfromania.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import com.sasd13.goinfromania.controller.FrameController;
import com.sasd13.goinfromania.util.GameConstants;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.menu.GameMenuBar;

public class Frame extends JFrame {
	
	private JLayeredPane layersPane;
	private GameMenuBar gameMenuBar;
	private HomeView homeView;
	private ListGamesView listGamesView;
	private GameView gameView;
	
	public Frame() {
		super(GameConstants.NAME);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		createGameMenuBar();
		setMenuEditEnabled(false);
		createLayers();
		addWindowListener(new FrameController());
	}
	
	private void createGameMenuBar() {
		gameMenuBar = new GameMenuBar();
		setJMenuBar(gameMenuBar);
	}
	
	public void setMenuEditEnabled(boolean enabled) {
		gameMenuBar.setMenuEditEnabled(enabled);
	}
	
	private void createLayers() {		
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
		layersPane.add(homeView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerListGames(Dimension dimension) {
		listGamesView = new ListGamesView();
		listGamesView.setBounds(0, 0, dimension.width, dimension.height);
		layersPane.add(listGamesView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerGame(Dimension dimension) {
		gameView = new GameView();
		gameView.setBounds(0, 0, dimension.width, dimension.height);
		layersPane.add(gameView, JLayeredPane.DEFAULT_LAYER);
	}
	
	public void displayHomeView() {
		setMenuEditEnabled(false);
		
		homeView.setVisible(true);
		layersPane.moveToFront(homeView);
		
		gameView.setVisible(false);
		listGamesView.setVisible(false);
	}
	
	public void displayListGamesView() {
		setMenuEditEnabled(false);
		
		listGamesView.setVisible(true);
		layersPane.moveToFront(listGamesView);
		
		homeView.setVisible(false);
		gameView.setVisible(false);
	}
	
	public void displayGameView() {
		setMenuEditEnabled(true);
		
		gameView.setVisible(true);
		gameView.getArenaView().requestFocusInWindow();
		layersPane.moveToFront(gameView);
		
		homeView.setVisible(false);
		listGamesView.setVisible(false);
	}
}
