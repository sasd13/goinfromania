package goinfromania.view.dialog;

import goinfromania.controller.SettingController;
import goinfromania.setting.Setting;
import goinfromania.view.DimensionConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class SettingDialog extends JDialog implements Observer {
	
	private SettingController settingController;

	protected SettingDialog() {
		super();
		
		setTitle("Option");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		createForm();
		createPanelButtons();
	}
	
	protected abstract void createForm();
	
	private void createPanelButtons() {
		JPanel panelButtons = new JPanel();
		
		addButtonsToPanelButton(panelButtons);
		
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButtons) {
		JButton[] buttons = {
				new JButton("Fermer"),
				new JButton("Appliquer"),
				new JButton("Reset")
		};
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		String command = null;
		this.settingController = new SettingController(this);
		
		int indice = -1;
		for (JButton button : buttons) {
			indice++;
			
			switch (indice) {
				case 0:
					command = "CLOSE";
					break;
				case 1:
					command = "SAVE";
					break;
				case 2:
					command = "RESET";
					break;
			}
			
			button.setPreferredSize(dimension);
			button.setFocusable(false);
			button.setActionCommand(command);
			button.addActionListener(this.settingController);
			
			panelButtons.add(button);
		}
	}
	
	public abstract boolean isFormValid();
	
	public abstract void editSettingWithForm(Setting setting);
	
	protected abstract Setting getSettingFromForm();
	
	@Override
	public void update(Observable observable, Object arg) {
		this.settingController.setSetting((Setting) observable);
	}
}
