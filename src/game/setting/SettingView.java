package game.setting;

import game.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SettingView extends JFrame implements Observer {

	private JButton buttonClose, buttonReset;
	
	public SettingView() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(DimensConst.FRAME_WIDTH_MEDIUM, DimensConst.FRAME_HEIGHT_MEDIUM));
		
		setTitle(Game.NAME);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		java.awt.Dimension dimen = new java.awt.Dimension(DimensConst.BUTTON_WIDTH, DimensConst.BUTTON_HEIGHT);
		
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
							setting.deleteObserver(SettingView.this);
							dispose();
							break;
						case JOptionPane.NO_OPTION :
							setting.deleteObserver(SettingView.this);
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
	}
}
