package goinfromania.view.frame;

import goinfromania.game.Game;
import goinfromania.view.DimensionConstants;

import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListGamesView extends JSplitPane implements ListSelectionListener {

	private static final int LIST_WIDTH = 300;
	
	private List<Game> games;
	
	private JList<String> listPane;
	private DefaultListModel<String> listModel;
	private GameDescriptorPane gamePane;
	
	public ListGamesView() {
		super(JSplitPane.HORIZONTAL_SPLIT);
		
		setDividerLocation(LIST_WIDTH);
		setListModel();
		addScrollPane();
		addGameDescriptorPane();
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}

	private void setListModel() {
		this.listModel = new DefaultListModel<>();
		
		this.listPane = new JList<>(this.listModel);
		this.listPane.setLayoutOrientation(JList.VERTICAL);
		this.listPane.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listPane.setVisibleRowCount(-1);
		this.listPane.addListSelectionListener(this);
	}

	private void addScrollPane() {
		JScrollPane listScroller = new JScrollPane(this.listPane);
		listScroller.setPreferredSize(new Dimension(LIST_WIDTH, DimensionConstants.PANEL_HEIGHT));
		add(listScroller);
	}
	
	private void addGameDescriptorPane() {
		this.gamePane = new GameDescriptorPane();
		add(this.gamePane);
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (event.getValueIsAdjusting() == false) {
	        if (this.listPane.getSelectedIndex() >= 0) {
	        	Game game = this.games.get(this.listPane.getSelectedIndex());
	        	this.gamePane.bind(game);
	        }
	    }
	}
}
