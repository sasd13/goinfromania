package view.help;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.DimensionConstants;
import view.menu.MenuHelp;

public abstract class HelpView extends JDialog implements ActionListener {

	private JButton buttonClose;
	
	public HelpView() {
		super();
		
		setTitle(MenuHelp.NAME);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setPreferredSize(dimension);
		this.buttonClose.setFocusable(false);
		this.buttonClose.addActionListener(this);
		panel.add(this.buttonClose);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		if (button == this.buttonClose) {
			dispose();
		}
	}
}
