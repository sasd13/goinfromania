package core.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import core.Game;
import core.IViewer;
import core.IViewable;

public class GameView extends JFrame implements IViewer {

	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	
	public GameView() {
		setDefaultCloseOperation(GameView.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
	}
	
	@Override
	public void bind(IViewable viewable) {
		Game game = (Game) viewable;
		
		setTitle(game.NAME);
	}
}
