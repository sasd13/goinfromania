package com.sasd13.goinfromania.view;

import javax.swing.SwingUtilities;

import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class App {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Gamepad gamepad = (Gamepad) SettingPreferencesFactory.make(EnumSetting.GAMEPAD.getCode()).pull();
				FrameView frameView = new FrameView(gamepad);

				frameView.displayHome();
				frameView.pack();
				frameView.setLocationRelativeTo(null);
				frameView.setVisible(true);
			}
		});
	}
}
