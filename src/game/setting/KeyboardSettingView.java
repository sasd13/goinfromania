package game.setting;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import patterns.Observable;

public class KeyboardSettingView extends SettingView {
	
	private final String LABEL_START = "Start",
		LABEL_PAUSE = "Pause",
		LABEL_MOVELEFT = "Left",
		LABEL_MOVERIGHT = "Right",
		LABEL_MOVEUP = "Up",
		LABEL_MOVEDOWN = "Down",
		LABEL_PIGATTAK = "Pig attak";
	
	private JLabel labelText;
	
	private JTextField textFieldKeyStart,
		textFieldKeyPause,
		textFieldKeyMoveLeft,
		textFieldKeyMoveRight,
		textFieldKeyMoveUp,
		textFieldKeyMoveDown,
		textFieldKeyPigAttak;
	
	public KeyboardSettingView() {
		super();
		
		this.labelText = new JLabel("Set keyboard controller touchs :");
		getContentPane().add(this.labelText, BorderLayout.NORTH);
		
		JPanel panelForm = new JPanel();
		getContentPane().add(panelForm, BorderLayout.CENTER);
		
		panelForm.setLayout(new GridLayout(7, 2));
		for(int i=0; i<7; i++) {
			switch (i) {
				case 0:
					panelForm.add(new JLabel(LABEL_START));
					this.textFieldKeyStart = new JTextField();
					panelForm.add(this.textFieldKeyStart);
					break;
				case 1:
					panelForm.add(new JLabel(LABEL_PAUSE));
					this.textFieldKeyPause = new JTextField();
					panelForm.add(this.textFieldKeyPause);
					break;
				case 2:
					panelForm.add(new JLabel(LABEL_MOVELEFT));
					this.textFieldKeyMoveLeft = new JTextField();
					panelForm.add(this.textFieldKeyMoveLeft);
					break;
				case 3:
					panelForm.add(new JLabel(LABEL_MOVERIGHT));
					this.textFieldKeyMoveRight = new JTextField();
					panelForm.add(this.textFieldKeyMoveRight);
					break;
				case 4:
					panelForm.add(new JLabel(LABEL_MOVEUP));
					this.textFieldKeyMoveUp = new JTextField();
					panelForm.add(this.textFieldKeyMoveUp);
					break;
				case 5:
					panelForm.add(new JLabel(LABEL_MOVEDOWN));
					this.textFieldKeyMoveDown = new JTextField();
					panelForm.add(this.textFieldKeyMoveDown);
					break;
				case 6:
					panelForm.add(new JLabel(LABEL_PIGATTAK));
					this.textFieldKeyPigAttak = new JTextField();
					panelForm.add(this.textFieldKeyPigAttak);
					break;
			}
		}
	}
	
	@Override
	public void update(Observable model) {
		KeyboardSetting keyboardParams = (KeyboardSetting) model;
		
		this.textFieldKeyStart.setText(KeyEvent.getKeyText(keyboardParams.getKeyStart()));
		this.textFieldKeyPause.setText(KeyEvent.getKeyText(keyboardParams.getKeyPause()));
		this.textFieldKeyMoveLeft.setText(KeyEvent.getKeyText(keyboardParams.getKeyMoveLeft()));
		this.textFieldKeyMoveRight.setText(KeyEvent.getKeyText(keyboardParams.getKeyMoveRight()));
		this.textFieldKeyMoveUp.setText(KeyEvent.getKeyText(keyboardParams.getKeyMoveUp()));
		this.textFieldKeyMoveDown.setText(KeyEvent.getKeyText(keyboardParams.getKeyMoveDown()));
		this.textFieldKeyPigAttak.setText(KeyEvent.getKeyText(keyboardParams.getKeyPigAttak()));
		
		super.update(model);
	}
}
