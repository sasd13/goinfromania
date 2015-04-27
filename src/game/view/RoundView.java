package game.view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import game.element.ListElement;
import game.element.character.Pig;
import game.round.Round;

public class RoundView extends JPanel implements Observer {
	
	private RoundStateView roundStateView;
	private PigStateView pigStateView;
	private GridView gridView;
	
	public RoundView() {
		super();
		
		setLayout(new BorderLayout());
		
		this.roundStateView = new RoundStateView();
		add(this.roundStateView, BorderLayout.SOUTH);
		
		this.pigStateView = new PigStateView();
		add(this.pigStateView, BorderLayout.NORTH);
		
		this.gridView = new GridView();
		add(this.gridView, BorderLayout.CENTER);
	}
	
	public GridView getGridView() {
		return this.gridView;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.roundStateView.getLabelRoundValue().setText(String.valueOf(round.getId()));
		this.roundStateView.getLabelScoreValue().setText(String.valueOf(round.getScore()));
		
		Pig pig = round.getPig();
		pig.addObserver(this.pigStateView);
		this.pigStateView.update(pig, arg);
		
		this.gridView.draw(pig);
		
		ListElement listElement = round.getListElement();
		for(int i=0; i<listElement.size(); i++) {
			this.gridView.draw(listElement.get(i));
		}
	}
}
