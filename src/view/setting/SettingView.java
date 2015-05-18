package view.setting;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.DimensionConstants;
import controller.SettingController;

public abstract class SettingView extends JDialog implements Observer, ActionListener {

	private JButton buttonClose, buttonReset;
	
	public SettingView() {
		super();
		
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setPreferredSize(dimension);
		this.buttonClose.addActionListener(this);
		panel.add(this.buttonClose);
		
		this.buttonReset = new JButton("Reset");
		this.buttonReset.setPreferredSize(dimension);
		this.buttonReset.addActionListener(this);
		panel.add(this.buttonReset);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		//TODO
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		if (button == this.buttonClose) {
			SettingController.closeSetting();
		} else if (button == this.buttonReset) {
			SettingController.resetSetting();
		}
	}
}
