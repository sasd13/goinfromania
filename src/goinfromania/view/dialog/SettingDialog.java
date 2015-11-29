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
	
	public SettingDialog() {
		super();
		
		this.settingController = new SettingController(this);
		
		prepareDialog();
		prepareButtons();
	}
	
	public abstract boolean isFormValid();
	
	public abstract void editSettingWithForm(Setting setting);
	
	protected abstract Setting getSettingFromForm();
	
	@Override
	public void update(Observable observable, Object arg) {
		this.settingController.setSetting((Setting) observable);
	}
	
	private void prepareDialog() {
		setTitle("Option");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
	}
	
	private void prepareButtons() {
		JPanel panelButtons = new JPanel();
		
		JButton[] buttons = {
				new JButton("Fermer"),
				new JButton("Reset")
		};
		
		String command = "Command";
		
		int indice = 0;
		for (JButton button : buttons) {
			switch (indice) {
				case 0:
					command = "CLOSE";
					break;
				case 1:
					command = "RESET";
					break;
			}
			
			button.setPreferredSize(new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT));
			button.setFocusable(false);
			button.addActionListener(this.settingController);
			button.setActionCommand(command);
			
			panelButtons.add(button);
		}
		
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}
}
