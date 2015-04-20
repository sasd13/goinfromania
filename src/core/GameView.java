package core;

import java.awt.Dimension;

import pattern.Observable;
import core.gui.menu.MenuBar;

public class GameView extends FrameView {
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	
	private MenuBar menuBar;
	
	public GameView() {
		super();
		
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		this.menuBar = new MenuBar();
		setJMenuBar(this.menuBar);
	}
	
	@Override
	public void update(Observable observable) {
		Game game = (Game) observable;
		
		setTitle(game.getTitle());
		
		super.update(observable);
	}
}
