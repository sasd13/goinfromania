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
		
		JLabel label = new JLabel("<html>Vous contr�ler un goinfre qui cherche � se nourrire de g�teaux."
				+ "<br>Pour gagner la partie vous devez atteindre l'objectif de g�teaux � manger."
				+ "<br><br>Plus vous en mangerez, plus vous aurez d'energie, et mieux vous saurez vous defendre contre vos ennemis."
				+ "<br>Mais attention! Tous les g�teaux ne sont pas bons � manger..."
				+ "<br><br>Vos ennemis sont les nutritionistes qui cherchent � vous emp�chez de manger, et les virus qui vous rendent malade. Vous devez-donc leur echapper!"
				+ "<br><br>Maintenant c'est parti! Que La Gourmandise Soit Avec Toi, jeune Padawan! ;-)</html>");
		label.setFont(font);
		
		getContentPane().add(label);
	}
}
