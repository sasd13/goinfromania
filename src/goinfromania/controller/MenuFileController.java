package goinfromania.controller;

import java.awt.event.ActionEvent;

public class MenuFileController extends MenuController {

	@Override
	public void actionPerformed(ActionEvent event) {
		GameController.getInstance().dispatch("menufile", event);
	}
}
