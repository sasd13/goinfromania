package game.setting;

import game.FrameView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SettingView extends FrameView {

	private JButton buttonClose, buttonReset;
	
	public SettingView() {
		super();
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		java.awt.Dimension dimen = new java.awt.Dimension(Dimension.BUTTON_WIDTH, Dimension.BUTTON_HEIGHT);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setPreferredSize(dimen);
		panel.add(this.buttonClose);
		
		this.buttonReset = new JButton("Reset");
		this.buttonReset.setPreferredSize(dimen);
		panel.add(this.buttonReset);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		final Setting setting = (Setting) observable;
		
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
							setting.deleteObserver(SettingView.this);
							break;
						case JOptionPane.NO_OPTION :
							dispose();
							setting.deleteObserver(SettingView.this);
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
		
		super.update(observable, arg);
	}
}
