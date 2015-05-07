package view;

import game.Game;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListRoundsView extends JPanel {

	public ListRoundsView() {
		super();
		
		setLayout(new BorderLayout());
		
		add(new JLabel(Game.NAME), BorderLayout.CENTER);
		setBackground(Color.BLUE);
	}
}
