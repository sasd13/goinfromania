package goinfromania.controller.menu;

import goinfromania.controller.GameManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFileController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		GameManager.getInstance().dispatch("MENUFILE", event);
	}
}
