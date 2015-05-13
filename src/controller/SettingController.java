package controller;

import javax.swing.JOptionPane;

import game.setting.GamePad;
import game.setting.Setting;
import game.util.ThreadSleeper;
import view.setting.GamePadView;
import view.setting.SettingView;
import db.SettingDAO;

public class SettingController {

	private static SettingController instance = null;
	
	private Setting setting;
	private SettingView settingView;
	
	private SettingController() {
		this.setting = null;
		this.settingView = null;
	}
	
	public static synchronized SettingController getInstance() {
		if (instance == null) {
			instance = new SettingController();
		}
		
		return instance;
	}
	
	public void openSetting(String settingName) {
		this.settingView = createView(settingName);
		
		this.setting = SettingDAO.load(settingName);
		this.setting.addObserver(this.settingView);
		this.settingView.update(this.setting, null);
		
		this.settingView.pack();
		this.settingView.setVisible(true);
	}
	
	public void closeSetting() {
		String title = "Confirmation";
		String message = "Save modifications ?";
		
		ThreadSleeper.defaultSleep();
		int selected = JOptionPane.showConfirmDialog(this.settingView, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			SettingDAO.save(this.setting);
		}
		
		this.setting.deleteObservers();		
		this.settingView.dispose();
	}
	
	public void resetSetting() {
		this.setting.reset();
	}
	
	private SettingView createView(String settingName) {
		switch (settingName) {
			case GamePad.NAME :
				return new GamePadView();
			default :
				//TODO Throw exception
				return null;
		}
	}
	
	public GamePad loadGamePad() {
		GamePad gamePad = (GamePad) SettingDAO.load(GamePad.NAME);
		
		return gamePad;
	}
}
