package game;

import game.menu.GameMenu;
import game.round.ListRound;
import game.round.ListRoundView;
import game.round.Round;
import game.round.RoundView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class GameView extends JFrame implements Observer, IViewable {
	
	private static GameView instance = null;
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	
	private GameMenu gameMenu;
	private ListRoundView listRoundView;
	private RoundView liveRoundView;
	
	private GameView() {
		super(Game.NAME);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		this.gameMenu = new GameMenu();
		setJMenuBar(this.gameMenu);
		
		this.listRoundView = new ListRoundView();
		getContentPane().add(this.listRoundView, BorderLayout.CENTER);
		
		this.liveRoundView = new RoundView();
	}
	
	public static synchronized GameView getInstance() {
		if(instance == null) {
			instance = new GameView();
		}
		
		return instance;
	}
	
	public ListRoundView getListRoundView() {
		return this.listRoundView;
	}
	
	public RoundView getLiveRoundView() {
		return this.liveRoundView;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		ListRound listRound = game.getListRound();
		if(listRound.countObservers() == 0) {
			listRound.addObserver(this.listRoundView);
		}
		this.listRoundView.update(listRound, null);
		
		Round liveRound = game.getLiveRound();
		if(liveRound != null) {
			if(liveRound.countObservers() == 0) {
				liveRound.addObserver(this.liveRoundView);
			}
			this.liveRoundView.update(liveRound, null);
		}
	}

	@Override
	public void display() {
		pack();
		setVisible(true);
	}

	@Override
	public void mask() {
		dispose();
	}
}
