package goinfromania.view.dialog;

import goinfromania.setting.GamePad;
import goinfromania.setting.Setting;
import goinfromania.view.DimensionConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePadDialog extends SettingDialog {
	
	private GamePadTextField textFieldKeyStart,
		textFieldKeyMoveNorth,
		textFieldKeyMoveSouth,
		textFieldKeyMoveWest,
		textFieldKeyMoveEast,
		textFieldKeyPigAttak;
	
	private GamePadTextField[] gamePadTextFields = {
			this.textFieldKeyStart,
			this.textFieldKeyMoveNorth,
			this.textFieldKeyMoveSouth,
			this.textFieldKeyMoveWest,
			this.textFieldKeyMoveEast,
			this.textFieldKeyPigAttak
	};
	
	@Override
	public void update(Observable observable, Object arg) {
		GamePad gamePad = (GamePad) observable;
		
		this.textFieldKeyStart.setText(KeyEvent.getKeyText(gamePad.getKeyStart()));
		this.textFieldKeyStart.setKeyCode(gamePad.getKeyStart());
		
		this.textFieldKeyMoveNorth.setText(KeyEvent.getKeyText(gamePad.getKeyMoveNorth()));
		this.textFieldKeyMoveNorth.setKeyCode(gamePad.getKeyMoveNorth());
		
		this.textFieldKeyMoveSouth.setText(KeyEvent.getKeyText(gamePad.getKeyMoveSouth()));
		this.textFieldKeyMoveSouth.setKeyCode(gamePad.getKeyMoveSouth());
		
		this.textFieldKeyMoveWest.setText(KeyEvent.getKeyText(gamePad.getKeyMoveWest()));
		this.textFieldKeyMoveWest.setKeyCode(gamePad.getKeyMoveWest());
		
		this.textFieldKeyMoveEast.setText(KeyEvent.getKeyText(gamePad.getKeyMoveEast()));
		this.textFieldKeyMoveEast.setKeyCode(gamePad.getKeyMoveEast());
		
		this.textFieldKeyPigAttak.setText(KeyEvent.getKeyText(gamePad.getKeyPigAttak()));
		this.textFieldKeyPigAttak.setKeyCode(gamePad.getKeyPigAttak());
		
		super.update(observable, arg);
	}
	
	@Override
	protected void prepareDialog() {
		super.prepareDialog();
		
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
	}
	
	@Override
	protected void createForm() {
		JPanel panelForm = new JPanel(new GridLayout(6, 2));
		panelForm.setBorder(BorderFactory.createTitledBorder("Configurer les touches du clavier"));
		
		String label = "Label";
		
		int indice = -1;
		for (GamePadTextField gamePadTextField : this.gamePadTextFields) {
			indice++;
			
			switch (indice) {
				case 0:
					label = "Start";
					break;
				case 1:
					label = "Move North";
					break;
				case 2:
					label = "Move South";
					break;
				case 3:
					label = "Move West";
					break;
				case 4:
					label = "Move East";
					break;
				case 5:
					label = "Pig Attak";
					break;
			}
			
			gamePadTextField = new GamePadTextField();
			
			panelForm.add(new JLabel(label));
			panelForm.add(gamePadTextField);
		}
		
		getContentPane().add(panelForm, BorderLayout.CENTER);
	}
	
	@Override
	public boolean isFormValid() {
		return !hasUndefined() && !hasDuplicated();
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
		
		gamePad.setKeyStart(this.textFieldKeyStart.getKeyCode());
		gamePad.setKeyMoveNorth(this.textFieldKeyMoveNorth.getKeyCode());
		gamePad.setKeyMoveSouth(this.textFieldKeyMoveSouth.getKeyCode());
		gamePad.setKeyMoveWest(this.textFieldKeyMoveWest.getKeyCode());
		gamePad.setKeyMoveEast(this.textFieldKeyMoveEast.getKeyCode());
		gamePad.setKeyPigAttak(this.textFieldKeyPigAttak.getKeyCode());
		
		return gamePad;		
	}
	
	private boolean hasUndefined() {
		for (GamePadTextField gamePadTextField : this.gamePadTextFields) {
			if (gamePadTextField.getKeyCode() == KeyEvent.VK_UNDEFINED) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean hasDuplicated() {
		for (int i=0; i<this.gamePadTextFields.length - 1; i++) {
			for (int j=i+1; j<this.gamePadTextFields.length; j++) {
				if (this.gamePadTextFields[i].getKeyCode() == this.gamePadTextFields[j].getKeyCode()) {
					return true;
				}
			}
		}
		
		return false;
	}
}
