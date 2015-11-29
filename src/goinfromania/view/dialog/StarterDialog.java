package goinfromania.view.dialog;

import goinfromania.view.DimensionConstants;
import goinfromania.view.frame.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StarterDialog extends GameDialog implements ActionListener {

	private JLayeredPane layeredPane;
	private JPanel panelReady, panelGo;
	
	private int count;
	private Timer timer;
	
	public StarterDialog() {
		super();
		
		setSize(new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT));
		setBackground(Color.BLACK);
		
		this.layeredPane = new JLayeredPane();
		this.layeredPane.setPreferredSize(new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT));
		setContentPane(this.layeredPane);
		
		this.panelReady = new JPanel();
		this.panelReady.setBackground(Color.BLACK);
		this.panelReady.setBounds(0, 0, DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		this.layeredPane.add(this.panelReady, JLayeredPane.DEFAULT_LAYER);
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96);
		
		JLabel labelReady = new JLabel("Ready !");
		labelReady.setFont(font);
		labelReady.setForeground(Color.PINK);
		this.panelReady.add(labelReady);
		
		this.panelGo = new JPanel();
		this.panelGo.setBackground(Color.BLACK);
		this.panelGo.setBounds(0, 0, DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		this.layeredPane.add(this.panelGo, JLayeredPane.DEFAULT_LAYER);
		
		JLabel labelGo = new JLabel("Go !");
		labelGo.setFont(font);
		labelGo.setForeground(Color.PINK);
		this.panelGo.add(labelGo);
	}
	
	public void anime() {
		this.count = 0;
		
		this.timer = new Timer(0, this);
		this.timer.setDelay(1200);
		
		setLocationRelativeTo(Frame.getInstance());
		
		this.timer.start();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.count++;
		
		if (this.count == 0) {
			this.panelReady.setVisible(true);
			this.layeredPane.moveToFront(this.panelReady);
			this.panelGo.setVisible(false);
		} else if (count == 1) {
			this.panelGo.setVisible(true);
			this.layeredPane.moveToFront(this.panelGo);
			this.panelReady.setVisible(false);
		} else {
			this.timer.stop();
			
			dispose();
		}
	}
}
