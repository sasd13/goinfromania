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
	
	private final String LABEL_START = "Start",
		LABEL_MOVELEFT = "Left",
		LABEL_MOVERIGHT = "Right",
		LABEL_MOVEUP = "Up",
		LABEL_MOVEDOWN = "Down",
		LABEL_PIGATTAK = "Pig attak";
	
	private JTextField textFieldKeyStart,
		textFieldKeyMoveLeft,
		textFieldKeyMoveRight,
		textFieldKeyMoveUp,
		textFieldKeyMoveDown,
		textFieldKeyPigAttak;
	
	public GamePadView() {
		super();
		
		JPanel panelForm = new JPanel();
		
		panelForm.setLayout(new GridLayout(7, 2));
		panelForm.setBorder(BorderFactory.createTitledBorder("Set keyboard controller touchs"));
		
		panelForm.add(new JLabel(LABEL_START));
		this.textFieldKeyStart = new JTextField();
		panelForm.add(this.textFieldKeyStart);
		
		panelForm.add(new JLabel(LABEL_MOVELEFT));
		this.textFieldKeyMoveLeft = new JTextField();
		panelForm.add(this.textFieldKeyMoveLeft);
		
		panelForm.add(new JLabel(LABEL_MOVERIGHT));
		this.textFieldKeyMoveRight = new JTextField();
		panelForm.add(this.textFieldKeyMoveRight);
		
		panelForm.add(new JLabel(LABEL_MOVEUP));
		this.textFieldKeyMoveUp = new JTextField();
		panelForm.add(this.textFieldKeyMoveUp);
		
		panelForm.add(new JLabel(LABEL_MOVEDOWN));
		this.textFieldKeyMoveDown = new JTextField();
		panelForm.add(this.textFieldKeyMoveDown);
		
		panelForm.add(new JLabel(LABEL_PIGATTAK));
		this.textFieldKeyPigAttak = new JTextField();
		panelForm.add(this.textFieldKeyPigAttak);
		
		getContentPane().add(panelForm, BorderLayout.CENTER);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		GamePad gamePad = (GamePad) observable;
		
		this.textFieldKeyStart.setText(KeyEvent.getKeyText(gamePad.getKeyStart()));
		this.textFieldKeyMoveLeft.setText(KeyEvent.getKeyText(gamePad.getKeyMoveLeft()));
		this.textFieldKeyMoveRight.setText(KeyEvent.getKeyText(gamePad.getKeyMoveRight()));
		this.textFieldKeyMoveUp.setText(KeyEvent.getKeyText(gamePad.getKeyMoveUp()));
		this.textFieldKeyMoveDown.setText(KeyEvent.getKeyText(gamePad.getKeyMoveDown()));
		this.textFieldKeyPigAttak.setText(KeyEvent.getKeyText(gamePad.getKeyPigAttak()));
		
		super.update(observable, arg);
	}
}
