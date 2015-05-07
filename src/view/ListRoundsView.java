package view;

import game.Game;
import game.round.ListRounds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListRoundsView extends JPanel implements Observer {

	public ListRoundsView() {
		super();
		
		setLayout(new BorderLayout());
		
		add(new JLabel(Game.NAME), BorderLayout.CENTER);
		setBackground(Color.BLUE);
	}

	@Override
	public void update(Observable observable, Object arg) {
		ListRounds listRounds = (ListRounds) observable;
		
	}
}
