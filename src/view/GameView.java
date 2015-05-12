package view;

import game.Game;
import game.menu.GameMenuBar;
import game.round.ListRounds;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import view.round.RoundView;

public class GameView extends JFrame implements Observer {
	
	private static GameView instance = null;
	
	private GameMenuBar gameMenuBar;
	
	private JLayeredPane layeredPane;
	
	private HomeView homeView;
	private ListRoundsView listRoundsView;
	private RoundView roundView;
	private ListScoresView listScoresView;
	
	private GameView() {
		super(Game.NAME);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		this.gameMenuBar = new GameMenuBar();
		setJMenuBar(this.gameMenuBar);
		
		this.layeredPane = new JLayeredPane();
		this.layeredPane.setPreferredSize(new Dimension(DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT));
		
		this.homeView = new HomeView();
		this.homeView.setBounds(0, 0, DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT);
		this.layeredPane.add(this.homeView, JLayeredPane.DEFAULT_LAYER);
		
		this.listRoundsView = new ListRoundsView();
		this.listRoundsView.setBounds(0, 0, DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT);
		this.layeredPane.add(this.listRoundsView, JLayeredPane.DEFAULT_LAYER);
		
		this.roundView = new RoundView();
		this.roundView.setBounds(0, 0, DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT);
		this.layeredPane.add(this.roundView, JLayeredPane.DEFAULT_LAYER);
		
		this.listScoresView = new ListScoresView();
		this.listScoresView.setBounds(0, 0, DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT);
		this.layeredPane.add(this.listScoresView, JLayeredPane.DEFAULT_LAYER);
		
		getContentPane().add(this.layeredPane, BorderLayout.CENTER);
	}
	
	public static synchronized GameView getInstance() {
		if (instance == null) {
			instance = new GameView();
		}
		
		return instance;
	}
	
	public RoundView getRoundView() {
		return this.roundView;
	}
	
	@Override
	public void update(Observable observable, Object arg) {		
		Game game = (Game) observable;
		
		ListRounds listRounds = game.getListRounds();
		
		listRounds.addObserver(this.listRoundsView);
		this.listRoundsView.update(listRounds, null);
		
		listRounds.addObserver(this.listScoresView);
		this.listScoresView.update(listRounds, null);
	}
	
	public void displayHomeView() {
		this.layeredPane.moveToFront(this.homeView);
		this.homeView.setVisible(true);
		
		this.listRoundsView.setVisible(false);
		this.listScoresView.setVisible(false);
		this.roundView.setVisible(false);
	}
	
	public void displayListRoundsView() {
		this.layeredPane.moveToFront(this.listRoundsView);
		this.listRoundsView.setVisible(true);
		
		this.homeView.setVisible(false);
		this.listScoresView.setVisible(false);
		this.roundView.setVisible(false);
	}
	
	public void displayListScoresView() {
		this.layeredPane.moveToFront(this.listScoresView);
		this.listScoresView.setVisible(true);
		
		this.homeView.setVisible(false);
		this.listRoundsView.setVisible(false);
		this.roundView.setVisible(false);
	}
	
	public void displayRoundView() {
		this.layeredPane.moveToFront(this.roundView);
		this.roundView.setVisible(true);
		
		this.homeView.setVisible(false);
		this.listRoundsView.setVisible(false);
		this.listScoresView.setVisible(false);
	}
}
