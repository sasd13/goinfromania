package view;

import game.round.ListRounds;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListRoundsView extends JSplitPane implements Observer, ListSelectionListener {

	private final int LIST_WIDTH = 300;
	
	private ListRounds listRounds;
	
	private JList<String> listPane;
	private DefaultListModel<String> listModel;
	
	private ListRoundsViewRoundPane roundPane;
	
	public ListRoundsView() {
		super(JSplitPane.HORIZONTAL_SPLIT);
		
		setDividerLocation(LIST_WIDTH);
		
		this.listRounds = new ListRounds();
		
		this.listModel = new DefaultListModel<>();
		
		this.listPane = new JList<>(this.listModel);
		this.listPane.setLayoutOrientation(JList.VERTICAL);
		this.listPane.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listPane.setVisibleRowCount(-1);
		this.listPane.addListSelectionListener(this);
		
		JScrollPane listScroller = new JScrollPane(this.listPane);
		listScroller.setPreferredSize(new Dimension(LIST_WIDTH, DimensionConstants.PANEL_HEIGHT));
		add(listScroller);
		
		this.roundPane = new ListRoundsViewRoundPane();
		add(this.roundPane);
	}

	@Override
	public void update(Observable observable, Object arg) {
		this.listRounds = (ListRounds) observable;
		
		String roundId;
		for (int i=0; i<this.listRounds.size(); i++) {
			roundId = this.listRounds.get(i).getId();
			
			if (!this.listModel.contains(roundId)) {
				this.listModel.addElement(roundId);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
	        if (this.listPane.getSelectedIndex() >= 0) {
	        	int index = this.listPane.getSelectedIndex();
	        	this.roundPane.bind(this.listRounds.get(index));
	        	this.roundPane.setVisible(true);
	        }
	    }
	}
}
