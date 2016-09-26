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

import com.sasd13.goinfromania.bean.setting.GamePad;
import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.util.ViewConstants;

public class SettingDialogGamePad extends SettingDialog {
	
	private class GamePadTextField extends JTextField {
		
		private int keyCode;

		public GamePadTextField() {
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
		
		public int getKeyCode() {
			return keyCode;
		}
		
		public void setKeyCode(int keyCode) {
			keyCode = keyCode;
		}
		
		private void dispatch(int keyCode) {
			setKeyCode(keyCode);
			
			if (keyCode != KeyEvent.VK_UNDEFINED) {
				setText(KeyEvent.getKeyText(keyCode));
			} else {
				setText("");
				JOptionPane.showMessageDialog(null, "Entrer une touche valide", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private GamePadTextField textFieldKeyStart,
		textFieldKeyMoveNorth,
		textFieldKeyMoveSouth,
		textFieldKeyMoveWest,
		textFieldKeyMoveEast,
		textFieldKeyPigAttak;
	
	private GamePadTextField[] textFields;
	
	public SettingDialogGamePad() {
		super();
		
		setPreferredSize(new Dimension(ViewConstants.FRAME_WIDTH, ViewConstants.FRAME_HEIGHT));
	}
	
	@Override
	protected void createForm() {
		textFields = new GamePadTextField[6];
		
		JPanel panelForm = new JPanel(new GridLayout(textFields.length, 2));
		panelForm.setBorder(BorderFactory.createTitledBorder("Configurer les touches du clavier"));
		
		addTextFieldsToPanelForm(panelForm);
		
		getContentPane().add(panelForm, BorderLayout.CENTER);
	}

	private void addTextFieldsToPanelForm(JPanel panelForm) {
		String label = "Label";
		
		for (int i=0; i<textFields.length; i++) {
			switch (i) {
				case 0:
					label = "Start";
					
					textFieldKeyStart = new GamePadTextField();
					textFields[i] = textFieldKeyStart;
					break;
				case 1:
					label = "Move North";
					
					textFieldKeyMoveNorth = new GamePadTextField();
					textFields[i] = textFieldKeyMoveNorth;
					break;
				case 2:
					label = "Move South";
					
					textFieldKeyMoveSouth = new GamePadTextField();
					textFields[i] = textFieldKeyMoveSouth;
					break;
				case 3:
					label = "Move West";
					
					textFieldKeyMoveWest = new GamePadTextField();
					textFields[i] = textFieldKeyMoveWest;
					break;
				case 4:
					label = "Move East";
					
					textFieldKeyMoveEast = new GamePadTextField();
					textFields[i] = textFieldKeyMoveEast;
					break;
				case 5:
					label = "Pig Attak";
					
					textFieldKeyPigAttak = new GamePadTextField();
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
		for (GamePadTextField gamePadTextField : textFields) {
			if (gamePadTextField.getKeyCode() == KeyEvent.VK_UNDEFINED) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean hasDuplicated() {
		for (int i=0; i<textFields.length - 1; i++) {
			for (int j=i+1; j<textFields.length; j++) {
				if (textFields[i].getKeyCode() == textFields[j].getKeyCode()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void editSettingWithForm(Setting setting) {
		GamePad gamePad = (GamePad) setting;
		
		GamePad gamePadFromForm = (GamePad) getSettingFromForm();
		
		gamePad.setKeyStart(gamePadFromForm.getKeyStart());
		gamePad.setKeyMoveNorth(gamePadFromForm.getKeyMoveNorth());
		gamePad.setKeyMoveSouth(gamePadFromForm.getKeyMoveSouth());
		gamePad.setKeyMoveWest(gamePadFromForm.getKeyMoveWest());
		gamePad.setKeyMoveEast(gamePadFromForm.getKeyMoveEast());
		gamePad.setKeyPigAttak(gamePadFromForm.getKeyPigAttak());
	}
	
	@Override
	protected Setting getSettingFromForm() {
		GamePad gamePad = new GamePad();
		
		gamePad.setKeyStart(textFieldKeyStart.getKeyCode());
		gamePad.setKeyMoveNorth(textFieldKeyMoveNorth.getKeyCode());
		gamePad.setKeyMoveSouth(textFieldKeyMoveSouth.getKeyCode());
		gamePad.setKeyMoveWest(textFieldKeyMoveWest.getKeyCode());
		gamePad.setKeyMoveEast(textFieldKeyMoveEast.getKeyCode());
		gamePad.setKeyPigAttak(textFieldKeyPigAttak.getKeyCode());
		
		return gamePad;		
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		GamePad gamePad = (GamePad) observable;
		
		textFieldKeyStart.setText(KeyEvent.getKeyText(gamePad.getKeyStart()));
		textFieldKeyStart.setKeyCode(gamePad.getKeyStart());
		
		textFieldKeyMoveNorth.setText(KeyEvent.getKeyText(gamePad.getKeyMoveNorth()));
		textFieldKeyMoveNorth.setKeyCode(gamePad.getKeyMoveNorth());
		
		textFieldKeyMoveSouth.setText(KeyEvent.getKeyText(gamePad.getKeyMoveSouth()));
		textFieldKeyMoveSouth.setKeyCode(gamePad.getKeyMoveSouth());
		
		textFieldKeyMoveWest.setText(KeyEvent.getKeyText(gamePad.getKeyMoveWest()));
		textFieldKeyMoveWest.setKeyCode(gamePad.getKeyMoveWest());
		
		textFieldKeyMoveEast.setText(KeyEvent.getKeyText(gamePad.getKeyMoveEast()));
		textFieldKeyMoveEast.setKeyCode(gamePad.getKeyMoveEast());
		
		textFieldKeyPigAttak.setText(KeyEvent.getKeyText(gamePad.getKeyPigAttak()));
		textFieldKeyPigAttak.setKeyCode(gamePad.getKeyPigAttak());
		
		super.update(observable, arg);
	}
}
