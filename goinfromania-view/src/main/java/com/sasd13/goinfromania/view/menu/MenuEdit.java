package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.controller.menu.edit.EnumMenuEditAction;
import com.sasd13.goinfromania.controller.menu.edit.MenuEditController;

public class MenuEdit extends JMenu {

	private static final long serialVersionUID = -4083803287551454249L;
	
	private MenuEditController menuEditController;

	public MenuEdit(IFrameView frameView) {
		super("Partie");

		buildView(frameView);
	}

	private void buildView(IFrameView frameView) {
		setMnemonic(KeyEvent.VK_P);
		buildItems(frameView);
	}

	private void buildItems(IFrameView frameView) {
		menuEditController = new MenuEditController(frameView);

		addItemStop();
		addItemSave();
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
