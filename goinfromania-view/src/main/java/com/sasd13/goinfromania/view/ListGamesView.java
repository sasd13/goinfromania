package com.sasd13.goinfromania.view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.dao.GameDAO;
import com.sasd13.goinfromania.util.ViewConstants;

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
		
		GameDAO.loadAll();
	}

	private void createPanelList() {
		panelList = new JList<>(new DefaultListModel<String>());
		panelList.setLayoutOrientation(JList.VERTICAL);
		panelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelList.setVisibleRowCount(-1);
		panelList.addListSelectionListener(this);
		
		addScrollPane();
	}

	private void addScrollPane() {
		JScrollPane listScroller = new JScrollPane(panelList);
		listScroller.setPreferredSize(new Dimension(LIST_WIDTH, ViewConstants.PANEL_HEIGHT));
		
		add(listScroller);
	}
	
	private void createGameDescriptorPane() {
		gamePane = new GameDescriptorPane();
		add(gamePane);
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (event.getValueIsAdjusting() == false) {
	        if (panelList.getSelectedIndex() >= 0) {
	        	Game game = games.get(panelList.getSelectedIndex());
	        	gamePane.bind(game);
	        }
	    }
	}
}
