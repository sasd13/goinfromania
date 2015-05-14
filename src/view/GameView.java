package view;

import game.Game;
import game.menu.GameMenuBar;
import game.round.ListRounds;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import controller.GameController;
import view.round.RoundView;

public class GameView extends JFrame implements Observer, WindowListener {
	
	private static GameView instance = null;
	
	private GameMenuBar gameMenuBar;
	private HomeView homeView;
	private RoundView roundView;
	private ListRoundsView listRoundsView;
	private ListScoresView listScoresView;
	
	private JLayeredPane layeredPane;
	
	private GameView() {
		super(Game.NAME);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		this.gameMenuBar = new GameMenuBar();
		setJMenuBar(this.gameMenuBar);
		
		this.layeredPane = new JLayeredPane();
		this.layeredPane.setPreferredSize(new Dimension(DimensionConstants.PANEL_WIDTH, DimensionConstants.PANEL_HEIGHT));
		getContentPane().add(this.layeredPane, BorderLayout.CENTER);
		
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
		
		addWindowListener(this);
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
		this.homeView.setVisible(true);
		this.layeredPane.moveToFront(this.homeView);
		
		this.roundView.setVisible(false);
		this.listRoundsView.setVisible(false);
		this.listScoresView.setVisible(false);
	}
	
	public void displayRoundView() {
		this.roundView.setVisible(true);
		this.layeredPane.moveToFront(this.roundView);
		
		this.homeView.setVisible(false);
		this.listRoundsView.setVisible(false);
		this.listScoresView.setVisible(false);
	}
	
	public void displayListRoundsView() {
		this.listRoundsView.setVisible(true);
		this.layeredPane.moveToFront(this.listRoundsView);
		
		this.homeView.setVisible(false);
		this.roundView.setVisible(false);
		this.listScoresView.setVisible(false);
	}
	
	public void displayListScoresView() {
		this.listScoresView.setVisible(true);
		this.layeredPane.moveToFront(this.listScoresView);
		
		this.homeView.setVisible(false);
		this.roundView.setVisible(false);
		this.listRoundsView.setVisible(false);
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
		GameController.getInstance().showDialogConfirmExitGame();
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
