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

	protected SettingController controller;
	
	protected SettingDialog() {
		super();
		
		prepareDialog();
		createForm();
		createDialogButtons();
	}
	
	protected abstract void createForm();
	
	public abstract boolean isFormValid();
	
	public abstract void editSettingWithForm(Setting setting);
	
	protected abstract Setting getSettingFromForm();
	
	@Override
	public void update(Observable observable, Object arg) {
		//Do nothing
	}
	
	protected void prepareDialog() {
		setTitle("Option");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
	}
	
	private void createDialogButtons() {
		JPanel panelButtons = new JPanel();
		
		JButton[] buttons = {
				new JButton("Fermer"),
				new JButton("Appliquer"),
				new JButton("Reset")
		};
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		String command = null;
		
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
			button.addActionListener(this.controller);
			
			panelButtons.add(button);
		}
		
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}
}
