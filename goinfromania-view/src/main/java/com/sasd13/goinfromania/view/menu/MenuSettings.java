package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.menu.settings.EnumMenuSettingsType;
import com.sasd13.goinfromania.controller.menu.settings.MenuSettingsController;

public class MenuSettings extends JMenu {

	public MenuSettings(IFrame frame) {
		super("Options");

		buildItems(new MenuSettingsController(frame));
		setMnemonic(KeyEvent.VK_O);
	}

	private void buildItems(MenuSettingsController controller) {
		JMenuItem menuItemGamePad = new JMenuItem("Clavier");
		menuItemGamePad.setActionCommand(EnumMenuSettingsType.GAMEPAD.getCode());
		menuItemGamePad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menuItemGamePad.addActionListener(controller);
		add(menuItemGamePad);
	}
}
