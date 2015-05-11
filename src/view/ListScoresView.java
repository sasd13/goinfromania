package view;

import game.round.ListRounds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListScoresView extends JPanel implements Observer {

	public ListScoresView() {
		super();
		
		setLayout(new BorderLayout());
		
		add(new JLabel("List scores"), BorderLayout.CENTER);
		setBackground(Color.GREEN);
	}

	@Override
	public void update(Observable observable, Object arg) {
		ListRounds listRounds = (ListRounds) observable;
		
	}
}
