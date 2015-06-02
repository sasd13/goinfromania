package main.java.view.help;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import main.java.view.DimensionConstants;

public class GameHelpView extends HelpView {
	
	public GameHelpView() {
		super();
		
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
		
		Font font = new Font(
				Font.SANS_SERIF,
				Font.PLAIN,
				getContentPane().getFont().getSize());
		
		JLabel label = new JLabel("<html>Vous contrôler un goinfre qui cherche à se nourrire de gâteaux."
				+ "<br>Pour gagner la partie vous devez atteindre l'objectif de gâteaux à manger."
				+ "<br><br>Plus vous en mangerez, plus vous aurez d'energie, et mieux vous saurez vous defendre contre vos ennemis."
				+ "<br>Mais attention! Tous les gâteaux ne sont pas bons à manger..."
				+ "<br><br>Vos ennemis sont les nutritionistes qui cherchent à vous empêchez de manger, et les virus qui vous rendent malade. Vous devez-donc leur echapper!"
				+ "<br><br>Maintenant c'est parti! Que La Gourmandise Soit Avec Toi, jeune Padawan! ;-)</html>");
		label.setFont(font);
		
		getContentPane().add(label);
	}
}
