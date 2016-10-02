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
import com.sasd13.goinfromania.controller.setting.EnumSettingAction;
import com.sasd13.goinfromania.controller.setting.ISettingDialog;
import com.sasd13.goinfromania.controller.setting.SettingController;
import com.sasd13.goinfromania.util.ViewConstants;

public abstract class SettingDialog extends JDialog implements Observer, ISettingDialog {

	private Setting setting;

	protected SettingDialog(IFrame frame, Setting setting) {
		super();

		this.setting = setting;

		buildView(frame);
	}

	private void buildView(IFrame frame) {
		setTitle("Option");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		buildForm();
		buildPanelButtons(frame);
	}

	protected abstract void buildForm();

	private void buildPanelButtons(IFrame frame) {
		JPanel panelButtons = new JPanel();

		addButtonsToPanelButton(panelButtons, frame);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButtons, IFrame frame) {
		Dimension dimension = new Dimension(ViewConstants.BUTTON_WIDTH, ViewConstants.BUTTON_HEIGHT);
		SettingController controller = new SettingController(frame, this, setting);

		addButtonClose(panelButtons, dimension, controller);
		addButtonSave(panelButtons, dimension, controller);
		addButtonReset(panelButtons, dimension, controller);
	}

	private void addButtonClose(JPanel panelButtons, Dimension dimension, SettingController controller) {
		JButton buttonClose = new JButton("Fermer");

		buttonClose.setPreferredSize(dimension);
		buttonClose.setFocusable(false);
		buttonClose.setActionCommand(EnumSettingAction.CLOSE.getCode());
		buttonClose.addActionListener(controller);
		panelButtons.add(buttonClose);
	}

	private void addButtonSave(JPanel panelButtons, Dimension dimension, SettingController controller) {
		JButton buttonSave = new JButton("Enregistrer");

		buttonSave.setPreferredSize(dimension);
		buttonSave.setFocusable(false);
		buttonSave.setActionCommand(EnumSettingAction.SAVE.getCode());
		buttonSave.addActionListener(controller);
		panelButtons.add(buttonSave);
	}

	private void addButtonReset(JPanel panelButtons, Dimension dimension, SettingController controller) {
		JButton buttonReset = new JButton("Reinitialiser");

		buttonReset.setPreferredSize(dimension);
		buttonReset.setFocusable(false);
		buttonReset.setActionCommand(EnumSettingAction.RESET.getCode());
		buttonReset.addActionListener(controller);
		panelButtons.add(buttonReset);
	}

	@Override
	public void update(Observable observable, Object arg) {
		// settingController.setSetting((Setting) observable);
	}

	@Override
	public boolean save() {
		if (!isFormValid()) {
			JOptionPane.showMessageDialog(this, "Configuration erron�e. Veuillez corriger", "Erreur", JOptionPane.ERROR_MESSAGE);

			return false;
		}

		editSettingWithForm(setting);

		return true;
	}
	
	protected abstract boolean isFormValid();

	protected abstract void editSettingWithForm(Setting setting);

	@Override
	public boolean askReset() {
		int selected = JOptionPane.showConfirmDialog(this, "Vous ne pourrez pas annuler les modifications. Confirmer?", "Option", JOptionPane.YES_NO_OPTION);

		return selected == JOptionPane.YES_OPTION;
	}
}
