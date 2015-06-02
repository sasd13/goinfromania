package controller;

import javax.swing.JOptionPane;

import pattern.dao.SettingDAO;
import game.setting.GamePad;
import game.setting.Setting;
import view.setting.GamePadView;
import view.setting.SettingView;

public class SettingController {

	private static Setting setting;
	private static SettingView settingView;
	
	public static void openSetting(String settingName) {
		try {
			settingView = createView(settingName);
			
			setting = SettingDAO.load(settingName);
			setting.addObserver(settingView);
			settingView.update(setting, null);
			
			settingView.pack();
			settingView.setLocationRelativeTo(null);
			settingView.setVisible(true);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeSetting(Setting newSetting) {
		String title = "Configuration";
		String message = "Enregistrer les modifications ?";
		
		int selected = JOptionPane.showConfirmDialog(settingView, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			SettingDAO.save(newSetting);
			
			setting.deleteObserver(settingView);
			settingView.dispose();
			
			if (!RoundController.hasRoundStopped()) {
				reloadSettingForRound(newSetting);
			}
		} else if (selected == JOptionPane.NO_OPTION) {
			setting.deleteObserver(settingView);
			settingView.dispose();
		}
	}
	
	private static void reloadSettingForRound(Setting setting) {
		if (setting.getName().compareTo(GamePad.NAME) == 0) {
			RoundController.loadGamePad();
		}
	}
	
	public static void resetSetting() {
		setting.reset();
	}
	
	private static SettingView createView(String settingName) {
		switch (settingName) {
			case GamePad.NAME :
				return new GamePadView();
			default :
				//TODO Throw exception
				return null;
		}
	}
}
