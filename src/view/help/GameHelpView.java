package view.help;

import java.awt.Dimension;

import view.DimensionConstants;

public class GameHelpView extends HelpView {
	
	public GameHelpView() {
		super();
		
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
	}
}
