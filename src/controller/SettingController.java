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
		settingView = createView(settingName);
		
		setting = SettingDAO.load(settingName);
		setting.addObserver(settingView);
		settingView.update(setting, null);
		
		settingView.pack();
		settingView.setLocationRelativeTo(null);
		settingView.setVisible(true);
	}
	
	public static void closeSetting(Setting newSetting) {
		if (!setting.equals(newSetting)) {
			String title = "Confirmation";
			String message = "Save modifications ?";
			
			int selected = JOptionPane.showConfirmDialog(settingView, message, title, JOptionPane.YES_NO_OPTION);
			if (selected == JOptionPane.YES_OPTION) {
				SettingDAO.save(newSetting);
				
				if (!RoundController.hasRoundStopped()) {
					reloadSettingForRound(newSetting);
				}
			}
			
			setting.deleteObserver(settingView);
			settingView.dispose();
		}
	}
	
	private static void reloadSettingForRound(Setting setting) {
		if (setting.getName().equals(GamePad.NAME)) {
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
	
	public static GamePad loadGamePad() {
		return (GamePad) SettingDAO.load(GamePad.NAME);
	}
}
