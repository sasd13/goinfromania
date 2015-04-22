package game;

import game.setting.Dimension;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public abstract class PanelView extends JPanel implements Observer, IViewable {

	public PanelView() {
		super();
		
		setPreferredSize(new java.awt.Dimension(Dimension.PANEL_LARGE, Dimension.PANEL_MEDIUM));
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		setVisible(true);
	}

	@Override
	public void mask() {
		setVisible(false);
	}
}
