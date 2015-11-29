package goinfromania.view.frame;

import goinfromania.controller.GameController;
import goinfromania.game.Game;
import goinfromania.view.DimensionConstants;
import goinfromania.view.menu.GameMenuBar;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class GameFrame extends JFrame {
	
	private static GameFrame instance = null;
	
	private JLayeredPane layeredPane;
	private GameMenuBar gameMenuBar;
	private HomeView homeView;
	private ListGamesView listGamesView;
	private GameView gameView;
	
	private GameController gameController;
	
	private GameFrame() {
		super(Game.NAME);
		
		this.gameController = GameController.getInstance();
		
		prepareFrame();
		createGameMenuBar();
		createLayers();
		
		this.gameController.setGameView(this.gameView);
	}
	
	public static synchronized GameFrame getInstance() {
		if (instance == null) {
			instance = new GameFrame();
		}
		
		return instance;
	}

	private void prepareFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		addWindowListener(this.gameController);
	}
	
	private void createGameMenuBar() {
		this.gameMenuBar = new GameMenuBar();
		setJMenuBar(this.gameMenuBar);
	}
	
	private void createLayers() {		
		Dimension dimension = new Dimension(DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT);
		
		this.layeredPane = new JLayeredPane();
		this.layeredPane.setPreferredSize(dimension);
		
		addLayerHome(dimension);
		addLayerListGames(dimension);
		addLayerGame(dimension);
		
		getContentPane().add(this.layeredPane);
	}

	private void addLayerHome(Dimension dimension) {
		this.homeView = new HomeView();
		this.homeView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.homeView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerListGames(Dimension dimension) {
		this.listGamesView = new ListGamesView();
		this.listGamesView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.listGamesView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerGame(Dimension dimension) {
		this.gameView = new GameView();
		this.gameView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.gameView, JLayeredPane.DEFAULT_LAYER);
	}
	
	public void show() {
		displayHomeView();
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void displayHomeView() {
		this.homeView.setVisible(true);
		this.layeredPane.moveToFront(this.homeView);
		
		this.gameView.setVisible(false);
		this.listGamesView.setVisible(false);
	}
	
	public void displayListGamesView() {
		this.listGamesView.setVisible(true);
		this.layeredPane.moveToFront(this.listGamesView);
		
		this.homeView.setVisible(false);
		this.gameView.setVisible(false);
	}
	
	public void displayGameView() {
		this.gameView.setVisible(true);
		this.layeredPane.moveToFront(this.gameView);
		
		this.homeView.setVisible(false);
		this.listGamesView.setVisible(false);
	}	
}
