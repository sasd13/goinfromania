package view;

import game.Game;
import game.setting.SettingListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class SettingView extends JFrame implements Observer {

	public static final String BUTTONCLOSE_NAME = "Close";
	public static final String BUTTONRESET_NAME = "Reset";
	
	private JButton buttonClose, buttonReset;
	
	public SettingView() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH_MEDIUM, DimensionConstants.FRAME_HEIGHT_MEDIUM));
		
		setTitle(Game.NAME);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		Dimension dimen = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		SettingListener listener = new SettingListener();
		
		this.buttonClose = new JButton(BUTTONCLOSE_NAME);
		this.buttonClose.setPreferredSize(dimen);
		this.buttonClose.addActionListener(listener);
		panel.add(this.buttonClose);
		
		this.buttonReset = new JButton(BUTTONRESET_NAME);
		this.buttonReset.setPreferredSize(dimen);
		this.buttonReset.addActionListener(listener);
		panel.add(this.buttonReset);
	}
	
	public JButton getButtonClose() {
		return this.buttonClose;
	}
	
	public JButton getButtonReset() {
		return this.buttonReset;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		//TODO
		
	}
}
