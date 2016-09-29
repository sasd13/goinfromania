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
import com.sasd13.goinfromania.controller.setting.ISettingDialog;
import com.sasd13.goinfromania.controller.setting.SettingController;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public abstract class SettingDialog extends JDialog implements Observer, ISettingDialog {
	
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
		
		Dimension dimension = new Dimension(ViewConstants.BUTTON_WIDTH, ViewConstants.BUTTON_HEIGHT);
		String command = null;
		settingController = new SettingController();
		
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
	public boolean reset(Setting setting) {
		int selected = JOptionPane.showConfirmDialog(this.settingDialog, "Vous ne pourrez pas annuler les modifications. Confirmer?", "Option", JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			setting.reset();
		}
	}
	
	@Override
	public boolean save(Setting setting) {
		if (isFormValid()) {
			settingDialog.editSettingWithForm(setting);
			SettingPreferencesFactory.make(settingType.getCode()).push(setting);

			JOptionPane.showMessageDialog(settingDialog, "Enregitsr�", "Option", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(settingDialog, "Configuration erron�e. Veuillez corriger", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
}
