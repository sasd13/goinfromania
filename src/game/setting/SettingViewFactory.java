package game.setting;

import game.Game;

public class SettingViewFactory {

	private SettingViewFactory() {}
	
	public static SettingView create(SettingType settingType) {
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
		
		return settingView;
	}
}
