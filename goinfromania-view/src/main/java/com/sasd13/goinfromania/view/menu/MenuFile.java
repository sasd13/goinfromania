package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.controller.menu.file.EnumMenuFileAction;
import com.sasd13.goinfromania.controller.menu.file.MenuFileController;

public class MenuFile extends JMenu {

	private static final long serialVersionUID = 6826023792031477806L;
	
	private MenuFileController menuFileController;

	public MenuFile(IFrameView frameView) {
		super("Fichier");

		buildView(frameView);
	}

	private void buildView(IFrameView frameView) {
		setMnemonic(KeyEvent.VK_F);
		buildItems(frameView);
	}

	private void buildItems(IFrameView frameView) {
		menuFileController = new MenuFileController(frameView);

		addItemNew();
		addItemOpen();
		addItemExit();
	}

	private void addItemNew() {
		JMenuItem menuItemNew = new JMenuItem("Nouveau");

		menuItemNew.setActionCommand(EnumMenuFileAction.NEW.getCode());
		menuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItemNew.addActionListener(menuFileController);
		add(menuItemNew);
	}

	private void addItemOpen() {
		JMenuItem menuItemOpen = new JMenuItem("Open");

		menuItemOpen.setActionCommand(EnumMenuFileAction.OPEN.getCode());
		menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menuItemOpen.addActionListener(menuFileController);
		add(menuItemOpen);
	}

	private void addItemExit() {
		JMenuItem menuItemExit = new JMenuItem("Exit");

		menuItemExit.setActionCommand(EnumMenuFileAction.EXIT.getCode());
		menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		menuItemExit.addActionListener(menuFileController);
		add(menuItemExit);
	}

	public void setGame(Game game) {
		menuFileController.setGame(game);
	}
}
