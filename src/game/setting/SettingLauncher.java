package game.setting;

import game.Game;

public class SettingLauncher {

	public static void launch(SettingType settingType) {
		SettingView settingView = null;
		
		switch (settingType) {
			case GAMEPAD :
				settingView = new GamePadView();
				break;
			default :
				break;
		}
		
		MapSetting mapSetting = Game.getInstance().getMapSetting();
		Setting setting = mapSetting.get(settingType);
		setting.addObserver(settingView);
		settingView.update(setting, null);
		
		settingView.pack();
		settingView.setVisible(true);
	}
}
