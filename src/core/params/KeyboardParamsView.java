package core.params;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.IViewable;

public class KeyboardParamsView extends ParamsView {
	
	private JLabel labelText;
	
	private JTextField textFieldKeyStart,
		textFieldKeyPause,
		textFieldKeyMoveLeft,
		textFieldKeyMoveRight,
		textFieldKeyMoveUp,
		textFieldKeyMoveDown,
		textFieldKeyPigAttak;
	
	public KeyboardParamsView() {
		super();
		
		this.labelText = new JLabel("Set keyboard touchs :");
		
		this.textFieldKeyStart = new JTextField();
		this.textFieldKeyPause = new JTextField();
		this.textFieldKeyMoveLeft = new JTextField();
		this.textFieldKeyMoveRight = new JTextField();
		this.textFieldKeyMoveUp = new JTextField();
		this.textFieldKeyMoveDown = new JTextField();
		this.textFieldKeyPigAttak = new JTextField();
		
		setContent();
	}
	
	@Override
	public void setContent() {
		super.setContent();
		
		getContentPane().add(this.labelText, BorderLayout.NORTH);
		
		JPanel panelForm = new JPanel();
		getContentPane().add(panelForm, BorderLayout.CENTER);
		
		panelForm.setLayout(new GridLayout(7, 2));
		for(int i=0; i<7; i++) {
			switch (i) {
				case 0:
					panelForm.add(new JLabel("Start"));
					panelForm.add(this.textFieldKeyStart);
					break;
				case 1:
					panelForm.add(new JLabel("Pause"));
					panelForm.add(this.textFieldKeyPause);
					break;
				case 2:
					panelForm.add(new JLabel("Left"));
					panelForm.add(this.textFieldKeyMoveLeft);
					break;
				case 3:
					panelForm.add(new JLabel("Right"));
					panelForm.add(this.textFieldKeyMoveRight);
					break;
				case 4:
					panelForm.add(new JLabel("Up"));
					panelForm.add(this.textFieldKeyMoveUp);
					break;
				case 5:
					panelForm.add(new JLabel("Down"));
					panelForm.add(this.textFieldKeyMoveDown);
					break;
				case 6:
					panelForm.add(new JLabel("Pig attak"));
					panelForm.add(this.textFieldKeyPigAttak);
					break;
			}
		}
	}
	
	@Override
	public void bind(IViewable viewable) {
		super.bind(viewable);
		
		KeyboardParams keyboardParams = (KeyboardParams) viewable;
		
		this.textFieldKeyStart.setText(KeyEvent.getKeyText(keyboardParams.getKeyStart()));
		this.textFieldKeyPause.setText(KeyEvent.getKeyText(keyboardParams.getKeyPause()));
		this.textFieldKeyMoveLeft.setText(KeyEvent.getKeyText(keyboardParams.getKeyMoveLeft()));
		this.textFieldKeyMoveRight.setText(KeyEvent.getKeyText(keyboardParams.getKeyMoveRight()));
		this.textFieldKeyMoveUp.setText(KeyEvent.getKeyText(keyboardParams.getKeyMoveUp()));
		this.textFieldKeyMoveDown.setText(KeyEvent.getKeyText(keyboardParams.getKeyMoveDown()));
	}
}
