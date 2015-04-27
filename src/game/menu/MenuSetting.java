package game.menu;

import game.setting.GamePad;
import game.setting.SettingController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuSetting extends JMenu implements ActionListener {

	private final String ITEM_GAMEPAD = "Gamepad";
	
	public MenuSetting() {
		super("Setting");
		
		JMenuItem itemGamePad = new JMenuItem(ITEM_GAMEPAD);
		itemGamePad.addActionListener(this);
		add(itemGamePad);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		if (item.getText().compareTo(ITEM_GAMEPAD) == 0) {
			SettingController.launch(GamePad.NAME);
		} else {
			//Throw exception
		}
	}
}
