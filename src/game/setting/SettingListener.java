package game.setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.SettingController;
import view.SettingView;

public class SettingListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		if (button.getText().compareTo(SettingView.BUTTONCLOSE_NAME) == 0) {
			SettingController.getInstance().close();
		} else if (button.getText().compareTo(SettingView.BUTTONRESET_NAME) == 0) {
			SettingController.getInstance().reset();
		} else {
			//TODO Thrw exception
		}
	}
}
