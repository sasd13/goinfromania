package goinfromania.view.frame;

import goinfromania.game.Game;
import goinfromania.view.DimensionConstants;
import goinfromania.view.dialog.GameDialog;
import goinfromania.view.dialog.ResultDialog;
import goinfromania.view.dialog.StarterDialog;
import goinfromania.view.menu.GameMenuBar;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class Frame extends JFrame implements WindowListener {
	
	private static final String GAMEDIALOG_STARTER = "STARTER";
	private static final String GAMEDIALOG_RESULT = "RESULT";
	
	private static Frame instance = null;
	
	private GameMenuBar gameMenuBar;
	
	private JLayeredPane layeredPane;
	private HomeView homeView;
	private ListGamesView listGamesView;
	private GameView gameView;
	private Map<String, GameDialog> mapDialogs;
	
	private Game game;
	
	private Frame() {
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
		
		this.listGamesView = new ListGamesView();
		this.listGamesView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.listGamesView, JLayeredPane.DEFAULT_LAYER);
		
		this.gameView = new GameView();
		this.gameView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.gameView, JLayeredPane.DEFAULT_LAYER);
		
		getContentPane().add(this.layeredPane);
		
		this.mapDialogs.put(GAMEDIALOG_STARTER, new StarterDialog());
		this.mapDialogs.put(GAMEDIALOG_RESULT, new ResultDialog());
	}
	
	public static synchronized Frame getInstance() {
		if (instance == null) {
			instance = new Frame();
		}
		
		return instance;
	}
	
	public void displayHomeView() {
		this.homeView.setVisible(true);
		this.layeredPane.moveToFront(this.homeView);
		
		this.gameView.setVisible(false);
		this.listGamesView.setVisible(false);
	}
	
	public void displayRoundView() {
		this.gameView.setVisible(true);
		this.layeredPane.moveToFront(this.gameView);
		
		this.homeView.setVisible(false);
		this.listGamesView.setVisible(false);
	}
	
	public void displayListRoundsView() {
		this.listGamesView.setVisible(true);
		this.layeredPane.moveToFront(this.listGamesView);
		
		this.homeView.setVisible(false);
		this.gameView.setVisible(false);
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
		showDialogConfirmExitGame();
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
	
	public void showDialogConfirmExitGame() {
		String title = Game.NAME;
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			exitGame();
		}
	}
	
	private void exitGame() {
		//TODO
		
		//game.deleteObservers();
		dispose();
		
		System.exit(0);
	}
}
