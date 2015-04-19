package core.params;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.IViewable;
import core.IViewer;

public class ParamsView extends JFrame implements IViewer {

	protected JPanel panelContent;
	private JPanel panelButton;
	private JButton buttonSave, buttonCancel, buttonReset;
	
	public ParamsView() {
		setPreferredSize(new Dimension(FRAME_DIM_MEDIUM, FRAME_DIM_MEDIUM));
		
		this.panelContent = new JPanel();
		getContentPane().add(this.panelContent, BorderLayout.CENTER);
		
		this.panelButton = new JPanel();
		this.panelButton.setLayout(new FlowLayout());
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setPreferredSize(new Dimension(BUTTON_DIM_WIDTH, BUTTON_DIM_HEIGHT));
		this.panelButton.add(this.buttonSave);
		
		this.buttonCancel = new JButton("Cancel");
		this.buttonCancel.setPreferredSize(new Dimension(BUTTON_DIM_WIDTH, BUTTON_DIM_HEIGHT));
		this.panelButton.add(this.buttonCancel);
		
		this.buttonReset = new JButton("Reset");
		this.buttonReset.setPreferredSize(new Dimension(BUTTON_DIM_WIDTH, BUTTON_DIM_HEIGHT));
		this.panelButton.add(this.buttonReset);
	}
	
	public void setContent() {};
	
	@Override
	public void bind(IViewable viewable) {
		final Params params = (Params) viewable;
		
		setTitle(params.getName());
		
		this.buttonSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String title = "Confirmation";
				String message = "Confirm save modifications ?";
				
				int selected = JOptionPane.showConfirmDialog(ParamsView.this, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
				if(selected == JOptionPane.YES_OPTION) {
					params.save();
					dispose();
				} else if(selected == JOptionPane.NO_OPTION) {
					dispose();
				}
			}
		});
		
		this.buttonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = "Confirmation";
				String message = "Your modifications will be losed. Confirm ?";
				
				int selected = JOptionPane.showConfirmDialog(ParamsView.this, message, title, JOptionPane.YES_NO_OPTION);
				if(selected == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		
		this.buttonReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				params.reset();
			}
		});
	}
	
	@Override
	public void display() {
		this.pack();
		this.setVisible(true);
	}
}
