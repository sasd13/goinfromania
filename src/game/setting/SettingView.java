package game.setting;

import game.Dimens;
import game.FrameView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import patterns.Observable;

public class SettingView extends FrameView {

	private JPanel panelButton;
	private JButton buttonClose, buttonReset;
	
	public SettingView() {
		super();
		
		this.panelButton = new JPanel();
		this.panelButton.setLayout(new FlowLayout());
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setPreferredSize(new Dimension(Dimens.BUTTON_WIDTH, Dimens.BUTTON_HEIGHT));
		this.panelButton.add(this.buttonClose);
		
		this.buttonReset = new JButton("Reset");
		this.buttonReset.setPreferredSize(new Dimension(Dimens.BUTTON_WIDTH, Dimens.BUTTON_HEIGHT));
		this.panelButton.add(this.buttonReset);
	}
	
	@Override
	public void update(Observable model) {
		final Setting setting = (Setting) model;
		
		if(this.buttonClose.getActionListeners().length == 0) {
			this.buttonClose.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String title = "Confirmation";
					String message = "Save modifications ?";
					
					int selected = JOptionPane.showConfirmDialog(SettingView.this, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
					switch (selected) {
						case JOptionPane.YES_OPTION :
							SettingManager.save(setting);
							dispose();
							break;
						case JOptionPane.NO_OPTION :
							dispose();
							break;					
					}
				}
			});
		}
		
		if(this.buttonReset.getActionListeners().length == 0) {
			this.buttonReset.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					setting.reset();
				}
			});
		}
		
		super.update(model);
	}
}
