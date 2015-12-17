package main.java.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import main.java.controller.SettingController;
import main.java.game.setting.GamePad;

public class MenuSetting extends JMenu implements ActionListener {

	public static final String NAME = "Configuration";
	
	private final String ITEM_GAMEPAD = "Clavier";
	
	public MenuSetting() {
		super(NAME);
		
		setMnemonic(KeyEvent.VK_C);
		
		JMenuItem itemGamePad = new JMenuItem(ITEM_GAMEPAD);
		itemGamePad.addActionListener(this);
		itemGamePad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		add(itemGamePad);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		if (item.getText().compareTo(ITEM_GAMEPAD) == 0) {
			SettingController.openSetting(GamePad.NAME);
		}
	}
}
