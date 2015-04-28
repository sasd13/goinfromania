package game.setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.SettingView;
import db.SettingDAO;

public class SettingListener implements ActionListener {

	private Setting setting;
	private SettingView settingView;
	
	public SettingListener(Setting setting, SettingView settingView) {
		this.setting = setting;
		this.settingView = settingView;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		if (button.getText().compareTo(SettingView.BUTTONCLOSE_NAME) == 0) {
			String title = "Confirmation";
			String message = "Save modifications ?";
			
			int selected = JOptionPane.showConfirmDialog(this.settingView, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
			switch (selected) {
				case JOptionPane.YES_OPTION :
					SettingDAO.save(this.setting);
					this.settingView.dispose();
					break;
				case JOptionPane.NO_OPTION :
					this.settingView.dispose();
					break;					
			}
		} else if (button.getText().compareTo(SettingView.BUTTONRESET_NAME) == 0) {
			this.setting.reset();
		} else {
			//TODO Thrw exception
		}
	}
}
