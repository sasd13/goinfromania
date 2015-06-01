package view.help;

import java.awt.Dimension;

import javax.swing.JPanel;

import view.DimensionConstants;

public class GamePadHelpView extends HelpView {
	
	public GamePadHelpView() {
		super();
		
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
		
		JPanel panelGamePad = new JPanel();
	}
}
