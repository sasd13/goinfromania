package com.sasd13.goinfromania.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.controller.menu.settings.EnumMenuSettingsAction;
import com.sasd13.goinfromania.controller.menu.settings.MenuSettingsController;

public class MenuSettings extends JMenu {

	private static final long serialVersionUID = 2180946428680907745L;
	
	private MenuSettingsController menuSettingsController;

	public MenuSettings(IFrameView frameView) {
		super("Options");

		buildView(frameView);
	}

	private void buildView(IFrameView frameView) {
		setMnemonic(KeyEvent.VK_O);
		buildItems(frameView);
	}

	private void buildItems(IFrameView frameView) {
		menuSettingsController = new MenuSettingsController(frameView);

		addItemGamepad(menuSettingsController);
	}

	private void addItemGamepad(MenuSettingsController controller) {
		JMenuItem menuItemGamepad = new JMenuItem("Clavier");

		menuItemGamepad.setActionCommand(EnumMenuSettingsAction.GAMEPAD.getCode());
		menuItemGamepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menuItemGamepad.addActionListener(controller);
		add(menuItemGamepad);
	}

	public void setGamepad(Gamepad gamepad) {
		menuSettingsController.setGamepad(gamepad);
	}
}
