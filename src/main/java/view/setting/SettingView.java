package main.java.view.setting;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.java.controller.SettingController;
import main.java.game.setting.Setting;
import main.java.view.DimensionConstants;
import main.java.view.menu.MenuSetting;

public abstract class SettingView extends JDialog implements Observer, ActionListener {

	private JButton buttonClose, buttonReset;
	
	public SettingView() {
		super();
		
		setTitle(MenuSetting.NAME);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonClose = new JButton("Fermer");
		this.buttonClose.setPreferredSize(dimension);
		this.buttonClose.setFocusable(false);
		this.buttonClose.addActionListener(this);
		panel.add(this.buttonClose);
		
		this.buttonReset = new JButton("Reset");
		this.buttonReset.setPreferredSize(dimension);
		this.buttonReset.setFocusable(false);
		this.buttonReset.addActionListener(this);
		panel.add(this.buttonReset);
	}
	
	@Override
	public void update(Observable observable, Object arg) {}
	
	protected abstract boolean checkChanges();
	
	protected abstract Setting editChanges();
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		if (button == this.buttonClose) {
			boolean checked = checkChanges();
			if (checked) {
				Setting newSetting = editChanges();
				
				SettingController.closeSetting(newSetting);
			} else {
				JOptionPane.showMessageDialog(this, "Configuration erronée. Vous devez corriger", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		} else if (button == this.buttonReset) {
			SettingController.resetSetting();
		}
	}
}
