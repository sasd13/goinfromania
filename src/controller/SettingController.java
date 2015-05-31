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
		//To center the frame on screen, must be called after pack()
		settingView.setLocationRelativeTo(null);
		settingView.setVisible(true);
	}
	
	public static void closeSetting() {
		String title = "Confirmation";
		String message = "Save modifications ?";
		
		int selected = JOptionPane.showConfirmDialog(settingView, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			SettingDAO.save(setting);
		}
		
		setting.deleteObservers();		
		settingView.dispose();
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
		GamePad gamePad = (GamePad) SettingDAO.load(GamePad.NAME);
		
		return gamePad;
	}
}
