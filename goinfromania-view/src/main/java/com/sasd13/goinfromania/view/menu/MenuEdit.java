package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.menu.edit.EnumMenuEditAction;
import com.sasd13.goinfromania.controller.menu.edit.MenuEditController;

public class MenuEdit extends JMenu {

	public MenuEdit(IFrame frame) {
		super("Partie");

		buildView(frame);
	}
	
	private void buildView(IFrame frame) {
		setMnemonic(KeyEvent.VK_P);
		buildItems(frame);
	}

	private void buildItems(IFrame frame) {
		MenuEditController controller = new MenuEditController(frame);
		
		addItemPause(controller);
		addItemStop(controller);
		addItemSave(controller);
	}

	private void addItemPause(MenuEditController controller) {
		JMenuItem menuItemPause = new JMenuItem("Pause / Reprise");
		
		menuItemPause.setActionCommand(EnumMenuEditAction.PAUSE.getCode());
		menuItemPause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		menuItemPause.addActionListener(controller);
		add(menuItemPause);
	}

	private void addItemStop(MenuEditController controller) {
		JMenuItem menuItemStop = new JMenuItem("Stop");
		
		menuItemStop.setActionCommand(EnumMenuEditAction.STOP.getCode());
		menuItemStop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		menuItemStop.addActionListener(controller);
		add(menuItemStop);
	}

	private void addItemSave(MenuEditController controller) {
		JMenuItem menuItemSave = new JMenuItem("Sauvegarder");
		
		menuItemSave.setActionCommand(EnumMenuEditAction.SAVE.getCode());
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItemSave.addActionListener(controller);
		add(menuItemSave);
	}
}
