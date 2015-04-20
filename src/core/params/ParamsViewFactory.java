package core.params;

import core.WindowController;
import core.round.RoundView;

public class ParamsViewFactory {

	private ParamsViewFactory() {}
	
	public static ParamsView create(ParamsType paramsType) {
		ParamsView paramsView = null;
		
		switch (paramsType) {
			case KEYBOARD :
				paramsView = new KeyboardParamsView();
				break;
			case ROUND :
				paramsView = new RoundView();
				break;
			default :
				return null;
		}
		
		Params params = ParamsManager.load(paramsType);
		WindowController controller = new WindowController(params, paramsView);
		paramsView.addWindowListener(controller);
		
		return paramsView;
	}
}
