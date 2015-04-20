package game;

import java.awt.Dimension;

import javax.swing.JFrame;

import patterns.Observable;
import patterns.Observer;

public class FrameView extends JFrame implements Observer {

	public FrameView() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(Dimens.FRAME_MEDIUM, Dimens.FRAME_MEDIUM));
	}
	
	@Override
	public void update(Observable observable) {
		Model model = (Model) observable;
		
		setTitle(model.getTitle());
	}

	@Override
	public void display() {
		pack();
		setVisible(true);
	}
}
