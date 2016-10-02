package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.menu.edit.EnumMenuEditAction;
import com.sasd13.goinfromania.controller.menu.edit.MenuEditController;

public class MenuEdit extends JMenu {

	private MenuEditController menuEditController;

	public MenuEdit(IFrame frame) {
		super("Partie");

		buildView(frame);
	}

	private void buildView(IFrame frame) {
		setMnemonic(KeyEvent.VK_P);
		buildItems(frame);
	}

	private void buildItems(IFrame frame) {
		menuEditController = new MenuEditController(frame);

		addItemPause();
		addItemStop();
		addItemSave();
	}

	private void addItemPause() {
		JMenuItem menuItemPause = new JMenuItem("Pause / Reprise");

		menuItemPause.setActionCommand(EnumMenuEditAction.PAUSE.getCode());
		menuItemPause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		menuItemPause.addActionListener(menuEditController);
		add(menuItemPause);
	}

	private void addItemStop() {
		JMenuItem menuItemStop = new JMenuItem("Stop");

		menuItemStop.setActionCommand(EnumMenuEditAction.STOP.getCode());
		menuItemStop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		menuItemStop.addActionListener(menuEditController);
		add(menuItemStop);
	}

	private void addItemSave() {
		JMenuItem menuItemSave = new JMenuItem("Sauvegarder");

		menuItemSave.setActionCommand(EnumMenuEditAction.SAVE.getCode());
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItemSave.addActionListener(menuEditController);
		add(menuItemSave);
	}

	public void setGame(Game game) {
		menuEditController.setGame(game);
	}
}
