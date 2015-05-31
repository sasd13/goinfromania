package view.setting;

import game.setting.GamePad;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePadView extends SettingView {
	
	private JTextField textFieldKeyStart,
		textFieldKeyMoveNorth,
		textFieldKeyMoveSouth,
		textFieldKeyMoveWest,
		textFieldKeyMoveEast,
		textFieldKeyPigAttak;
	
	public GamePadView() {
		super();
		
		JPanel panelForm = new JPanel(new GridLayout(7, 2));
		panelForm.setBorder(BorderFactory.createTitledBorder("Set keyboard controller touchs"));
		getContentPane().add(panelForm, BorderLayout.CENTER);
		
		panelForm.add(new JLabel("Start"));
		this.textFieldKeyStart = new JTextField();
		panelForm.add(this.textFieldKeyStart);
		
		panelForm.add(new JLabel("Move North"));
		this.textFieldKeyMoveNorth = new JTextField();
		panelForm.add(this.textFieldKeyMoveNorth);
		
		panelForm.add(new JLabel("Move South"));
		this.textFieldKeyMoveSouth = new JTextField();
		panelForm.add(this.textFieldKeyMoveSouth);
		
		panelForm.add(new JLabel("Move West"));
		this.textFieldKeyMoveWest = new JTextField();
		panelForm.add(this.textFieldKeyMoveWest);
		
		panelForm.add(new JLabel("Move Eastt"));
		this.textFieldKeyMoveEast = new JTextField();
		panelForm.add(this.textFieldKeyMoveEast);
		
		panelForm.add(new JLabel("Pig Attak"));
		this.textFieldKeyPigAttak = new JTextField();
		panelForm.add(this.textFieldKeyPigAttak);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		GamePad gamePad = (GamePad) observable;
		
		this.textFieldKeyStart.setText(KeyEvent.getKeyText(gamePad.getKeyStart()));
		this.textFieldKeyMoveNorth.setText(KeyEvent.getKeyText(gamePad.getKeyMoveNorth()));
		this.textFieldKeyMoveSouth.setText(KeyEvent.getKeyText(gamePad.getKeyMoveSouth()));
		this.textFieldKeyMoveWest.setText(KeyEvent.getKeyText(gamePad.getKeyMoveWest()));
		this.textFieldKeyMoveEast.setText(KeyEvent.getKeyText(gamePad.getKeyMoveEast()));
		this.textFieldKeyPigAttak.setText(KeyEvent.getKeyText(gamePad.getKeyPigAttak()));
		
		super.update(observable, arg);
	}
}
