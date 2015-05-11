package view;

import java.awt.Dimension;

import javax.swing.JDialog;

public class RoundMenuView extends JDialog {

	public RoundMenuView() {
		super();
		
		setSize(new Dimension(DimensionConstants.ARENA_WIDTH, DimensionConstants.ARENA_HEIGHT));
	}
}
