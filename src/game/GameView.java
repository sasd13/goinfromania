package game;

import game.menu.GameMenu;
import game.round.ListRound;
import game.round.ListRoundView;
import game.round.Round;
import game.round.RoundView;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class GameView extends JFrame implements Observer {
	
	private static GameView instance = null;
	
	private GameMenu gameMenu;
	private ListRoundView listRoundView;
	private RoundView liveRoundView;
	
	private GameView() {
		super(Game.NAME);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.gameMenu = new GameMenu();
		setJMenuBar(this.gameMenu);
		
		this.listRoundView = new ListRoundView();
		getContentPane().add(this.listRoundView, BorderLayout.CENTER);
		
		this.liveRoundView = new RoundView();
	}
	
	public static synchronized GameView getInstance() {
		if (instance == null) {
			instance = new GameView();
		}
		
		return instance;
	}
	
	@Override
	public void update(Observable observable, Object arg) {		
		Game game = (Game) observable;
		
		ListRound listRound = game.getListRound();
		if (listRound != null) {
			listRound.addObserver(this.listRoundView);
			this.listRoundView.update(listRound, null);
		}
		
		Round liveRound = game.getLiveRound();
		if (liveRound != null) {
			liveRound.addObserver(this.liveRoundView);
			this.liveRoundView.update(liveRound, null);
		}
	}
	
	public void displayListRoundView() {		
		getContentPane().remove(this.liveRoundView);
		getContentPane().add(this.listRoundView, BorderLayout.CENTER);
		
		validate();
		repaint();
	}
	
	public void displayLiveRoundView() {
		getContentPane().remove(this.listRoundView);
		getContentPane().add(this.liveRoundView, BorderLayout.CENTER);
		
		validate();
		repaint();
	}
}
