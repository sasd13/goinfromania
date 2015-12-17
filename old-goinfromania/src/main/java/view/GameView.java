package main.java.view;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import main.java.controller.GameController;
import main.java.game.Game;
import main.java.game.round.ListRounds;
import main.java.view.menu.GameMenuBar;
import main.java.view.round.RoundView;

public class GameView extends JFrame implements Observer, WindowListener {
	
	private static GameView instance = null;
	
	private GameMenuBar gameMenuBar;
	private HomeView homeView;
	private RoundView roundView;
	private ListRoundsView listRoundsView;
	
	private JLayeredPane layeredPane;
	
	private GameView() {
		super(Game.NAME);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		addWindowListener(this);
		
		this.gameMenuBar = new GameMenuBar();
		setJMenuBar(this.gameMenuBar);
		
		Dimension dimension = new Dimension(DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT);
		
		this.layeredPane = new JLayeredPane();
		this.layeredPane.setPreferredSize(dimension);
		
		this.homeView = new HomeView();
		this.homeView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.homeView, JLayeredPane.DEFAULT_LAYER);
		
		this.listRoundsView = new ListRoundsView();
		this.listRoundsView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.listRoundsView, JLayeredPane.DEFAULT_LAYER);
		
		this.roundView = new RoundView();
		this.roundView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.roundView, JLayeredPane.DEFAULT_LAYER);
		
		getContentPane().add(this.layeredPane);
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
	}
	
	public void displayHomeView() {
		this.homeView.setVisible(true);
		this.layeredPane.moveToFront(this.homeView);
		
		this.roundView.setVisible(false);
		this.listRoundsView.setVisible(false);
	}
	
	public void displayRoundView() {
		this.roundView.setVisible(true);
		this.layeredPane.moveToFront(this.roundView);
		
		this.homeView.setVisible(false);
		this.listRoundsView.setVisible(false);
	}
	
	public void displayListRoundsView() {
		this.listRoundsView.setVisible(true);
		this.layeredPane.moveToFront(this.listRoundsView);
		
		this.homeView.setVisible(false);
		this.roundView.setVisible(false);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		GameController.showDialogConfirmExitGame();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
