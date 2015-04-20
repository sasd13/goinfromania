package game.params;

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

public class ParamsView extends FrameView {

	private JPanel panelButton;
	private JButton buttonClose, buttonReset;
	
	public ParamsView() {
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
		final Params params = (Params) model;
		
		this.buttonClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String title = "Confirmation";
				String message = "Save modifications ?";
				
				int selected = JOptionPane.showConfirmDialog(ParamsView.this, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
				switch (selected) {
					case JOptionPane.YES_OPTION :
						ParamsManager.save(params);
						dispose();
						break;
					case JOptionPane.NO_OPTION :
						dispose();
						break;					
				}
			}
		});
		
		this.buttonReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				params.reset();
			}
		});
		
		super.update(model);
	}
}
