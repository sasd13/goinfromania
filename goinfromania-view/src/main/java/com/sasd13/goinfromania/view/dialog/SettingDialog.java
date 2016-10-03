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
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.controller.setting.EnumSettingDialogAction;
import com.sasd13.goinfromania.controller.setting.ISettingDialog;
import com.sasd13.goinfromania.controller.setting.SettingDialogController;
import com.sasd13.goinfromania.util.ViewConstants;

public abstract class SettingDialog extends JDialog implements Observer, ISettingDialog {

	private Setting setting;

	protected SettingDialog(IFrameView frameView, Setting setting) {
		super();

		this.setting = setting;

		buildView(frameView);
	}

	private void buildView(IFrameView frameView) {
		setTitle("Option");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		buildForm();
		buildPanelButtons(frameView);
	}

	protected abstract void buildForm();

	private void buildPanelButtons(IFrameView frameView) {
		JPanel panelButtons = new JPanel();

		addButtonsToPanelButton(panelButtons, frameView);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButtons, IFrameView frameView) {
		Dimension dimension = new Dimension(ViewConstants.BUTTON_WIDTH, ViewConstants.BUTTON_HEIGHT);
		SettingDialogController controller = new SettingDialogController(frameView, this, setting);

		addButtonClose(panelButtons, dimension, controller);
		addButtonSave(panelButtons, dimension, controller);
		addButtonReset(panelButtons, dimension, controller);
	}

	private void addButtonClose(JPanel panelButtons, Dimension dimension, SettingDialogController controller) {
		JButton buttonClose = new JButton("Fermer");

		buttonClose.setPreferredSize(dimension);
		buttonClose.setFocusable(false);
		buttonClose.setActionCommand(EnumSettingDialogAction.CLOSE.getCode());
		buttonClose.addActionListener(controller);
		panelButtons.add(buttonClose);
	}

	private void addButtonSave(JPanel panelButtons, Dimension dimension, SettingDialogController controller) {
		JButton buttonSave = new JButton("Enregistrer");

		buttonSave.setPreferredSize(dimension);
		buttonSave.setFocusable(false);
		buttonSave.setActionCommand(EnumSettingDialogAction.SAVE.getCode());
		buttonSave.addActionListener(controller);
		panelButtons.add(buttonSave);
	}

	private void addButtonReset(JPanel panelButtons, Dimension dimension, SettingDialogController controller) {
		JButton buttonReset = new JButton("Reinitialiser");

		buttonReset.setPreferredSize(dimension);
		buttonReset.setFocusable(false);
		buttonReset.setActionCommand(EnumSettingDialogAction.RESET.getCode());
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
