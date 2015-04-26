package game.setting;

import game.Game;
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
		
		ListSetting listSetting = Game.getInstance().getMapSetting();
		Setting setting = listSetting.get(settingName);
		setting.addObserver(settingView);
		settingView.update(setting, null);
		
		settingView.pack();
		settingView.setVisible(true);
	}
}
