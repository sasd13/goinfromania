package main.java.view.help;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.java.view.DimensionConstants;

public class GamePadHelpView extends HelpView {
	
	public GamePadHelpView() {
		super();
		
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
		
		Font fontPane = new Font(
				Font.SANS_SERIF,
				Font.BOLD | Font.ITALIC,
				20);
		
		JLabel labelTitle = new JLabel("Touches clavier", SwingConstants.HORIZONTAL);
		labelTitle.setFont(fontPane);
		getContentPane().add(labelTitle, BorderLayout.NORTH);
		
		JPanel panel = new JPanel(new GridLayout(3, 2));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		Font font = new Font(
				Font.SANS_SERIF,
				Font.PLAIN,
				getContentPane().getFont().getSize());
		
		JLabel labelTitleStart = new JLabel("Start");
		panel.add(labelTitleStart);
		
		JLabel labelDescriptionStart = new JLabel("Mettre en pause ou reprendre le jeu");
		labelDescriptionStart.setFont(font);
		panel.add(labelDescriptionStart);
		
		JLabel labelTitleMove = new JLabel("Directions Nord/Sud/Est/West");
		panel.add(labelTitleMove);
		
		JLabel labelDescriptionMove = new JLabel("Déplacer le goinfre dans les quatres directions");
		labelDescriptionMove.setFont(font);
		panel.add(labelDescriptionMove);
		
		JLabel labelTitlePigAttak = new JLabel("Attaque Goinfre");
		panel.add(labelTitlePigAttak);
		
		JLabel labelDescriptionPigAttak = new JLabel("Déclencher un pouvoir du Goinfre");
		labelDescriptionPigAttak.setFont(font);
		panel.add(labelDescriptionPigAttak);
	}
}
