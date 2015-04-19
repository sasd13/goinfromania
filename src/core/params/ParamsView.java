package core.params;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import core.IViewable;
import core.IViewer;

public class ParamsView extends JFrame implements IViewer {

	public ParamsView() {
		setPreferredSize(new Dimension(FRAME_DIM_MEDIUM, FRAME_DIM_MEDIUM));
	}
	
	@Override
	public void bind(IViewable viewable) {
		Params params = (Params) viewable;
		
		setTitle(params.getName());
	}
	
	public void setContent() {};
}
