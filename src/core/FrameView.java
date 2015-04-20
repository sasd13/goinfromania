package core;

import java.awt.Dimension;

import javax.swing.JFrame;

import pattern.Observable;
import pattern.Observer;

public class FrameView extends JFrame implements Observer {

	public FrameView() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(Dimens.FRAME_DIM_MEDIUM, Dimens.FRAME_DIM_MEDIUM));
	}
	
	@Override
	public void update(Observable observable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		pack();
		setVisible(true);
	}
}
