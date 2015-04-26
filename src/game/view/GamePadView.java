package game.view;

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
		LABEL_PAUSE = "Pause",
		LABEL_MOVELEFT = "Left",
		LABEL_MOVERIGHT = "Right",
		LABEL_MOVEUP = "Up",
		LABEL_MOVEDOWN = "Down",
		LABEL_PIGATTAK = "Pig attak";
	
	private JTextField textFieldKeyStart,
		textFieldKeyPause,
		textFieldKeyMoveLeft,
		textFieldKeyMoveRight,
		textFieldKeyMoveUp,
		textFieldKeyMoveDown,
		textFieldKeyPigAttak;
	
	public GamePadView() {
		super();
		
		JPanel panelForm = new JPanel();
		getContentPane().add(panelForm, BorderLayout.CENTER);
		
		panelForm.setBorder(BorderFactory.createTitledBorder(
                "Set keyboard controller touchs"));
		
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
	public void update(Observable observable, Object arg) {
		GamePad gamePad = (GamePad) observable;
		
		this.textFieldKeyStart.setText(KeyEvent.getKeyText(gamePad.getKeyStart()));
		this.textFieldKeyPause.setText(KeyEvent.getKeyText(gamePad.getKeyPause()));
		this.textFieldKeyMoveLeft.setText(KeyEvent.getKeyText(gamePad.getKeyMoveLeft()));
		this.textFieldKeyMoveRight.setText(KeyEvent.getKeyText(gamePad.getKeyMoveRight()));
		this.textFieldKeyMoveUp.setText(KeyEvent.getKeyText(gamePad.getKeyMoveUp()));
		this.textFieldKeyMoveDown.setText(KeyEvent.getKeyText(gamePad.getKeyMoveDown()));
		this.textFieldKeyPigAttak.setText(KeyEvent.getKeyText(gamePad.getKeyPigAttak()));
		
		super.update(observable, arg);
	}
}
