package game.setting;

import game.view.GamePadView;
import game.view.SettingView;

public class SettingLauncher {

	public static void launch(String settingName) {
		SettingView settingView = null;
		
		switch (settingName) {
			case GamePad.NAME :
				settingView = new GamePadView();
				break;
			default :
				break;
		}
		
		Setting setting = SettingManager.load(settingName);
		setting.addObserver(settingView);
		settingView.update(setting, null);
		
		settingView.pack();
		settingView.setVisible(true);
	}
}
