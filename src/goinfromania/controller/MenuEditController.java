package goinfromania.controller;

import java.awt.event.ActionEvent;

public class MenuEditController extends MenuController {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		GameController.getInstance().dispatch("menuedit", event);
	}
}
