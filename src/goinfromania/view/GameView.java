package goinfromania.view;

import goinfromania.Game;
import goinfromania.view.menubar.GameMenuBar;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class GameView extends JFrame implements WindowListener {
	
	private static final String GAMEDIALOG_STARTER = "STARTER";
	private static final String GAMEDIALOG_RESULT = "RESULT";
	
	private static GameView instance = null;
	
	private GameMenuBar gameMenuBar;
	
	private JLayeredPane layeredPane;
	private HomeView homeView;
	private GamesView gamesView;
	private ArenaView arenaView;
	private Map<String, GameDialog> mapDialogs;
	
	private Game game;
	
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
		
		this.gamesView = new GamesView();
		this.gamesView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.gamesView, JLayeredPane.DEFAULT_LAYER);
		
		this.arenaView = new ArenaView();
		this.arenaView.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.arenaView, JLayeredPane.DEFAULT_LAYER);
		
		getContentPane().add(this.layeredPane);
		
		this.mapDialogs.put(GAMEDIALOG_STARTER, new GameDialogStarter());
		this.mapDialogs.put(GAMEDIALOG_RESULT, new GameDialogResult());
	}
	
	public static synchronized GameView getInstance() {
		if (instance == null) {
			instance = new GameView();
		}
		
		return instance;
	}
	
	public void displayHomeView() {
		this.homeView.setVisible(true);
		this.layeredPane.moveToFront(this.homeView);
		
		this.arenaView.setVisible(false);
		this.gamesView.setVisible(false);
	}
	
	public void displayRoundView() {
		this.arenaView.setVisible(true);
		this.layeredPane.moveToFront(this.arenaView);
		
		this.homeView.setVisible(false);
		this.gamesView.setVisible(false);
	}
	
	public void displayListRoundsView() {
		this.gamesView.setVisible(true);
		this.layeredPane.moveToFront(this.gamesView);
		
		this.homeView.setVisible(false);
		this.arenaView.setVisible(false);
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
