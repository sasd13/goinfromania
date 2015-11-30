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
	
	private JList<String> panelList;
	private GameDescriptorPane gamePane;
	
	public ListGamesView() {
		super(JSplitPane.HORIZONTAL_SPLIT);
		
		setDividerLocation(LIST_WIDTH);
		createPanelList();
		createGameDescriptorPane();
	}

	private void createPanelList() {
		this.panelList = new JList<>(new DefaultListModel<String>());
		this.panelList.setLayoutOrientation(JList.VERTICAL);
		this.panelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.panelList.setVisibleRowCount(-1);
		this.panelList.addListSelectionListener(this);
		
		addScrollPane();
	}

	private void addScrollPane() {
		JScrollPane listScroller = new JScrollPane(this.panelList);
		listScroller.setPreferredSize(new Dimension(LIST_WIDTH, DimensionConstants.PANEL_HEIGHT));
		
		add(listScroller);
	}
	
	private void createGameDescriptorPane() {
		this.gamePane = new GameDescriptorPane();
		add(this.gamePane);
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (event.getValueIsAdjusting() == false) {
	        if (this.panelList.getSelectedIndex() >= 0) {
	        	Game game = this.games.get(this.panelList.getSelectedIndex());
	        	this.gamePane.bind(game);
	        }
	    }
	}
}
