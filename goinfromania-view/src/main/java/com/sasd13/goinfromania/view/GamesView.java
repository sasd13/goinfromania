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
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.util.builder.GamesListStringBuilder;

public class GamesView extends JSplitPane implements ListSelectionListener {

	private IFrame frame;
	private JList<String> panelList;
	private GameDescriptorPane gameDescriptorPane;
	private List<Game> games;
	
	public GamesView(IFrame frame) {
		super(JSplitPane.HORIZONTAL_SPLIT);
		
		this.frame = frame;
		
		setDividerLocation(ViewConstants.PANEL_LIST_WIDTH);
		createPanelList();
		createGameDescriptorPane();
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
		
		setData();
	}
	
	private void setData() {
		List<String> listData = new GamesListStringBuilder(games).build();
		panelList.setListData(listData.toArray(new String[listData.size()]));
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
		listScroller.setPreferredSize(new Dimension(ViewConstants.PANEL_LIST_WIDTH, ViewConstants.PANEL_HEIGHT));
		
		add(listScroller);
	}
	
	private void createGameDescriptorPane() {
		gameDescriptorPane = new GameDescriptorPane(frame);
		
		add(gameDescriptorPane);
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (!event.getValueIsAdjusting() && panelList.getSelectedIndex() >= 0) {
			gameDescriptorPane.bind(games.get(panelList.getSelectedIndex()));
	    }
	}
}
