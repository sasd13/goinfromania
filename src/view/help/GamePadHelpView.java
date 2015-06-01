package view.help;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import view.DimensionConstants;

public class GamePadHelpView extends HelpView {
	
	public GamePadHelpView() {
		super();
		
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
		
		JPanel panelGamePad = new JPanel(new GridLayout(6, 2));
	}
}
