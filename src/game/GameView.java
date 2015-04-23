package game;

import game.menu.GameMenu;
import game.round.ListRound;
import game.round.ListRoundView;
import game.round.Round;
import game.round.RoundView;
import game.setting.MapSetting;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;

public class GameView extends FrameView {
	
	private static GameView instance = null;
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	
	private GameMenu gameMenu;
	private ListRoundView listRoundView;
	private RoundView liveRoundView;
	
	private GameView() {
		super();
		
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		this.gameMenu = new GameMenu();
		setJMenuBar(this.gameMenu);
		
		this.listRoundView = new ListRoundView();
		
		this.liveRoundView = new RoundView();
		getContentPane().add(this.liveRoundView, BorderLayout.CENTER);
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
	
	public RoundView getRoundView() {
		return this.liveRoundView;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		MapSetting mapSetting = game.getMapSetting();
		
		ListRound listRound = game.getListRound();
		this.listRoundView.update(listRound, null);
		
		Round liveRound = game.getLiveRound();
		this.liveRoundView.update(liveRound, null);
		
		super.update(observable, arg);
	}
}
