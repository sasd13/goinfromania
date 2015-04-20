package game.setting;

import game.Game;
import game.WindowController;

public class SettingViewFactory {

	private SettingViewFactory() {}
	
	public static SettingView create(SettingType settingType) {
		SettingView settingView = null;
		
		switch (settingType) {
			case KEYBOARD :
				settingView = new KeyboardSettingView();
				break;
			default :
				break;
		}
		
		Setting setting = Game.getInstance().getSetting(settingType);
		WindowController controller = new WindowController(setting, settingView);
		settingView.addWindowListener(controller);
		
		return settingView;
	}
}
