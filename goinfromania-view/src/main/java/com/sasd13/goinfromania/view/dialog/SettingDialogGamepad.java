package com.sasd13.goinfromania.view.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.FrameView;

public class SettingDialogGamepad extends SettingDialog {

	private static class GamepadTextField extends JTextField {

		private int keyCode;

		public GamepadTextField() {
			super();

			keyCode = KeyEvent.VK_UNDEFINED;

			addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					select(0, getText().length());
				}

				@Override
				public void focusLost(FocusEvent e) {
					select(0, 0);
				}
			});

			addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					dispatch(arg0.getKeyCode());
				}

				@Override
				public void keyPressed(KeyEvent arg0) {
					dispatch(arg0.getKeyCode());
				}
			});
		}

		private void dispatch(int keyCode) {
			this.keyCode = keyCode;

			if (keyCode != KeyEvent.VK_UNDEFINED) {
				setText(KeyEvent.getKeyText(keyCode));
			} else {
				setText("");
				JOptionPane.showMessageDialog(null, "Entrer une touche valide", "Gamepad", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private GamepadTextField textFieldKeyStart, textFieldKeyMoveNorth, textFieldKeyMoveSouth, textFieldKeyMoveWest, textFieldKeyMoveEast, textFieldKeyPigAttak;

	private GamepadTextField[] textFields;

	public SettingDialogGamepad(FrameView frameView, Setting setting) {
		super(frameView, setting);

		setPreferredSize(new Dimension(ViewConstants.FRAME_WIDTH, ViewConstants.FRAME_HEIGHT));
	}

	@Override
	protected void buildForm() {
		textFields = new GamepadTextField[6];
		JPanel panelForm = new JPanel(new GridLayout(textFields.length, 2));

		panelForm.setBorder(BorderFactory.createTitledBorder("Configurer les touches du clavier"));
		addTextFieldsToPanelForm(panelForm);
		getContentPane().add(panelForm, BorderLayout.CENTER);
	}

	private void addTextFieldsToPanelForm(JPanel panelForm) {
		String label = "Label";

		for (int i = 0; i < textFields.length; i++) {
			switch (i) {
				case 0:
					label = "Start";

					textFieldKeyStart = new GamepadTextField();
					textFields[i] = textFieldKeyStart;
					break;
				case 1:
					label = "Move North";

					textFieldKeyMoveNorth = new GamepadTextField();
					textFields[i] = textFieldKeyMoveNorth;
					break;
				case 2:
					label = "Move South";

					textFieldKeyMoveSouth = new GamepadTextField();
					textFields[i] = textFieldKeyMoveSouth;
					break;
				case 3:
					label = "Move West";

					textFieldKeyMoveWest = new GamepadTextField();
					textFields[i] = textFieldKeyMoveWest;
					break;
				case 4:
					label = "Move East";

					textFieldKeyMoveEast = new GamepadTextField();
					textFields[i] = textFieldKeyMoveEast;
					break;
				case 5:
					label = "Pig Attak";

					textFieldKeyPigAttak = new GamepadTextField();
					textFields[i] = textFieldKeyPigAttak;
					break;
			}

			panelForm.add(new JLabel(label));
			panelForm.add(textFields[i]);
		}
	}

	@Override
	public boolean isFormValid() {
		return !hasUndefined() && !hasDuplicated();
	}

	private boolean hasUndefined() {
		for (GamepadTextField gamepadTextField : textFields) {
			if (gamepadTextField.keyCode == KeyEvent.VK_UNDEFINED) {
				return true;
			}
		}

		return false;
	}

	private boolean hasDuplicated() {
		for (int i = 0; i < textFields.length - 1; i++) {
			for (int j = i + 1; j < textFields.length; j++) {
				if (textFields[i].keyCode == textFields[j].keyCode) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void editSettingWithForm(Setting setting) {
		Gamepad gamepad = (Gamepad) setting;
		Gamepad gamepadFromForm = getGamepadFromForm();

		gamepad.setKeyStart(gamepadFromForm.getKeyStart());
		gamepad.setKeyMoveNorth(gamepadFromForm.getKeyMoveNorth());
		gamepad.setKeyMoveSouth(gamepadFromForm.getKeyMoveSouth());
		gamepad.setKeyMoveWest(gamepadFromForm.getKeyMoveWest());
		gamepad.setKeyMoveEast(gamepadFromForm.getKeyMoveEast());
		gamepad.setKeyPigAttak(gamepadFromForm.getKeyPigAttak());
	}

	private Gamepad getGamepadFromForm() {
		Gamepad gamepad = new Gamepad();

		gamepad.setKeyStart(textFieldKeyStart.keyCode);
		gamepad.setKeyMoveNorth(textFieldKeyMoveNorth.keyCode);
		gamepad.setKeyMoveSouth(textFieldKeyMoveSouth.keyCode);
		gamepad.setKeyMoveWest(textFieldKeyMoveWest.keyCode);
		gamepad.setKeyMoveEast(textFieldKeyMoveEast.keyCode);
		gamepad.setKeyPigAttak(textFieldKeyPigAttak.keyCode);

		return gamepad;
	}

	@Override
	public void update(Observable observable, Object arg) {
		Gamepad gamepad = (Gamepad) observable;

		setTextFieldKeyStart(gamepad);
		setTextFieldKeyMoveNorth(gamepad);
		setTextFieldKeyMoveSouth(gamepad);
		setTextFieldKeyMoveWest(gamepad);
		setTextFieldKeyMoveEast(gamepad);
		setTextFieldPigAttak(gamepad);
	}

	private void setTextFieldKeyStart(Gamepad gamepad) {
		textFieldKeyStart.setText(KeyEvent.getKeyText(gamepad.getKeyStart()));
		textFieldKeyStart.keyCode = gamepad.getKeyStart();
	}

	private void setTextFieldKeyMoveNorth(Gamepad gamepad) {
		textFieldKeyMoveNorth.setText(KeyEvent.getKeyText(gamepad.getKeyMoveNorth()));
		textFieldKeyMoveNorth.keyCode = gamepad.getKeyMoveNorth();
	}

	private void setTextFieldKeyMoveSouth(Gamepad gamepad) {
		textFieldKeyMoveSouth.setText(KeyEvent.getKeyText(gamepad.getKeyMoveSouth()));
		textFieldKeyMoveSouth.keyCode = gamepad.getKeyMoveSouth();
	}

	private void setTextFieldKeyMoveWest(Gamepad gamepad) {
		textFieldKeyMoveWest.setText(KeyEvent.getKeyText(gamepad.getKeyMoveWest()));
		textFieldKeyMoveWest.keyCode = gamepad.getKeyMoveWest();
	}

	private void setTextFieldKeyMoveEast(Gamepad gamepad) {
		textFieldKeyMoveEast.setText(KeyEvent.getKeyText(gamepad.getKeyMoveEast()));
		textFieldKeyMoveEast.keyCode = gamepad.getKeyMoveEast();
	}

	private void setTextFieldPigAttak(Gamepad gamepad) {
		textFieldKeyPigAttak.setText(KeyEvent.getKeyText(gamepad.getKeyPigAttak()));
		textFieldKeyPigAttak.keyCode = gamepad.getKeyPigAttak();
	}
}
