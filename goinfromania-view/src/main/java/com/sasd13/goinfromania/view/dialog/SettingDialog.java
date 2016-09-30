package com.sasd13.goinfromania.view.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.setting.ISettingDialog;
import com.sasd13.goinfromania.controller.setting.SettingController;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public abstract class SettingDialog extends JDialog implements Observer, ISettingDialog {
	
	private Setting setting;
	private String settingCode;
	private SettingController settingController;

	protected SettingDialog(IFrame frame, Setting setting, String settingCode) {
		super();
		
		this.setting = setting;
		this.settingCode = settingCode;
		
		setTitle("Option");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		createForm();
		createPanelButtons(frame);
	}
	
	protected abstract void createForm();
	
	private void createPanelButtons(IFrame frame) {
		JPanel panelButtons = new JPanel();
		
		addButtonsToPanelButton(panelButtons, frame);
		
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButtons, IFrame frame) {
		JButton[] buttons = {
				new JButton("Fermer"),
				new JButton("Appliquer"),
				new JButton("Reset")
		};
		
		Dimension dimension = new Dimension(ViewConstants.BUTTON_WIDTH, ViewConstants.BUTTON_HEIGHT);
		String command = null;
		settingController = new SettingController(frame, this, setting);
		
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
			button.addActionListener(settingController);
			
			panelButtons.add(button);
		}
	}
	
	public abstract boolean isFormValid();
	
	public abstract void editSettingWithForm(Setting setting);
	
	protected abstract Setting getSettingFromForm();
	
	@Override
	public void update(Observable observable, Object arg) {
		//settingController.setSetting((Setting) observable);
	}
	
	@Override
	public boolean save() {
		if (isFormValid()) {
			editSettingWithForm(setting);
			SettingPreferencesFactory.make(settingCode).push(setting);

			JOptionPane.showMessageDialog(this, "Enregitsr�", "Option", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Configuration erron�e. Veuillez corriger", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
		return true;
	}
	
	@Override
	public boolean askReset() {
		int selected = JOptionPane.showConfirmDialog(this, "Vous ne pourrez pas annuler les modifications. Confirmer?", "Option", JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			return true;
		}
		
		return false;
	}
}
