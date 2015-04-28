package controller;

import game.setting.GamePad;
import game.setting.Setting;
import game.setting.SettingListener;
import view.GamePadView;
import view.SettingView;
import db.SettingDAO;

public class SettingController {

	public static void launch(String settingName) {
		SettingView settingView = null;
		
		switch (settingName) {
			case GamePad.NAME :
				settingView = new GamePadView();
				break;
			default :
				//TODO Throw exception
				break;
		}
		
		Setting setting = SettingDAO.load(settingName);
		setting.addObserver(settingView);
		settingView.update(setting, null);
		
		SettingListener listener = new SettingListener(setting, settingView);
		settingView.getButtonClose().addActionListener(listener);
		settingView.getButtonReset().addActionListener(listener);
		
		settingView.pack();
		settingView.setVisible(true);
	}
}
