package core;

import java.awt.Dimension;

import javax.swing.JFrame;

import core.gui.menu.MenuBar;

public class GameView extends JFrame implements IViewer {

	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	
	public GameView() {
		setDefaultCloseOperation(GameView.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);
	}
	
	@Override
	public void bind(IViewable viewable) {
		Game game = (Game) viewable;
		
		setTitle(game.NAME);
	}
	
	@Override
	public void display() {
		pack();
		setVisible(true);
	}
}
