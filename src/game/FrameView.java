package game;

import game.setting.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public abstract class FrameView extends JFrame implements Observer, IViewable {

	public FrameView() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(Dimension.FRAME_MEDIUM, Dimension.FRAME_MEDIUM));
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Model model = (Model) observable;
		
		setTitle(model.getTitle());
	}

	@Override
	public void display() {
		pack();
		setVisible(true);
	}

	@Override
	public void mask() {
		setVisible(false);
	}
}
