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
	
	private GamePadTextField[] textFields;
	
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
		this.textFields = new GamePadTextField[6];
		
		JPanel panelForm = new JPanel(new GridLayout(this.textFields.length, 2));
		panelForm.setBorder(BorderFactory.createTitledBorder("Configurer les touches du clavier"));
		
		String label = "Label";
		
		for (int i=0; i<this.textFields.length; i++) {
			switch (i) {
				case 0:
					label = "Start";
					
					this.textFieldKeyStart = new GamePadTextField();
					this.textFields[i] = this.textFieldKeyStart;
					break;
				case 1:
					label = "Move North";
					
					this.textFieldKeyMoveNorth = new GamePadTextField();
					this.textFields[i] = this.textFieldKeyMoveNorth;
					break;
				case 2:
					label = "Move South";
					
					this.textFieldKeyMoveSouth = new GamePadTextField();
					this.textFields[i] = this.textFieldKeyMoveSouth;
					break;
				case 3:
					label = "Move West";
					
					this.textFieldKeyMoveWest = new GamePadTextField();
					this.textFields[i] = this.textFieldKeyMoveWest;
					break;
				case 4:
					label = "Move East";
					
					this.textFieldKeyMoveEast = new GamePadTextField();
					this.textFields[i] = this.textFieldKeyMoveEast;
					break;
				case 5:
					label = "Pig Attak";
					
					this.textFieldKeyPigAttak = new GamePadTextField();
					this.textFields[i] = this.textFieldKeyPigAttak;
					break;
			}
			
			panelForm.add(new JLabel(label));
			panelForm.add(this.textFields[i]);
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
		for (GamePadTextField gamePadTextField : this.textFields) {
			if (gamePadTextField.getKeyCode() == KeyEvent.VK_UNDEFINED) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean hasDuplicated() {
		for (int i=0; i<this.textFields.length - 1; i++) {
			for (int j=i+1; j<this.textFields.length; j++) {
				if (this.textFields[i].getKeyCode() == this.textFields[j].getKeyCode()) {
					return true;
				}
			}
		}
		
		return false;
	}
}
