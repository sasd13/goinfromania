package view;

import java.awt.BorderLayout;
import java.awt.Color;

import game.Game;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeView extends JPanel {

	public HomeView() {
		super();
		
		setLayout(new BorderLayout());
		
		add(new JLabel(Game.NAME), BorderLayout.CENTER);
		setBackground(Color.PINK);
	}
}
