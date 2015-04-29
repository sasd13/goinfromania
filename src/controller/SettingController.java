package controller;

import javax.swing.JOptionPane;

import game.setting.GamePad;
import game.setting.Setting;
import view.GamePadView;
import view.SettingView;
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
	
	private void display() {
		this.settingView.pack();
		this.settingView.setVisible(true);
	}
	
	private void dispose() {
		this.setting = null;		
		this.settingView.dispose();
	}
	
	public void open(String settingName) {
		switch (settingName) {
			case GamePad.NAME :
				this.settingView = new GamePadView();
				break;
			default :
				//TODO Throw exception
				break;
		}
		
		this.setting = SettingDAO.load(settingName);
		this.setting.addObserver(settingView);
		this.settingView.update(setting, null);
		
		display();
	}
	
	public void close() {
		String title = "Confirmation";
		String message = "Save modifications ?";
		
		int selected = JOptionPane.showConfirmDialog(this.settingView, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
		switch (selected) {
			case JOptionPane.YES_OPTION :
				SettingDAO.save(this.setting);
				break;
			case JOptionPane.NO_OPTION :
				break;					
		}
		
		dispose();
	}
	
	public void reset() {
		this.setting.reset();
	}
}
