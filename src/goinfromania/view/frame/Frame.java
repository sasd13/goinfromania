package goinfromania.view.frame;

import goinfromania.controller.FrameController;
import goinfromania.game.Game;
import goinfromania.view.DimensionConstants;
import goinfromania.view.menu.GameMenuBar;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Frame extends JFrame {
	
	private JLayeredPane layersPane;
	private GameMenuBar gameMenuBar;
	private HomeView homeView;
	private ListGamesView listGamesView;
	private GameView gameView;
	
	public Frame() {
		super(Game.NAME);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		createGameMenuBar();
		setMenuEditEnabled(false);
		createLayers();
		
		addWindowListener(new FrameController(this));
	}
	
	private void createGameMenuBar() {
		this.gameMenuBar = new GameMenuBar();
		setJMenuBar(this.gameMenuBar);
	}
	
	private void createLayers() {		
		Dimension dimension = new Dimension(DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT);
		
		this.layersPane = new JLayeredPane();
		this.layersPane.setPreferredSize(dimension);
		
		addLayerHome(dimension);
		addLayerListGames(dimension);
		addLayerGame(dimension);
		
		getContentPane().add(this.layersPane);
	}

	private void addLayerHome(Dimension dimension) {
		this.homeView = new HomeView();
		this.homeView.setBounds(0, 0, dimension.width, dimension.height);
		this.layersPane.add(this.homeView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerListGames(Dimension dimension) {
		this.listGamesView = new ListGamesView();
		this.listGamesView.setBounds(0, 0, dimension.width, dimension.height);
		this.layersPane.add(this.listGamesView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerGame(Dimension dimension) {
		this.gameView = new GameView();
		this.gameView.setBounds(0, 0, dimension.width, dimension.height);
		this.layersPane.add(this.gameView, JLayeredPane.DEFAULT_LAYER);
	}
	
	public ListGamesView getListGamesView() {
		return listGamesView;
	}
	
	public GameView getGameView() {
		return gameView;
	}
	
	public void displayHomeView() {
		this.homeView.setVisible(true);
		this.layersPane.moveToFront(this.homeView);
		
		this.gameView.setVisible(false);
		this.listGamesView.setVisible(false);
	}
	
	public void displayListGamesView() {
		this.listGamesView.setVisible(true);
		this.layersPane.moveToFront(this.listGamesView);
		
		this.homeView.setVisible(false);
		this.gameView.setVisible(false);
	}
	
	public void displayGameView() {
		this.gameView.setVisible(true);
		this.layersPane.moveToFront(this.gameView);
		
		this.homeView.setVisible(false);
		this.listGamesView.setVisible(false);
	}
	
	public void setMenuEditEnabled(boolean enabled) {
		this.gameMenuBar.setMenuEditEnabled(enabled);
	}
}
