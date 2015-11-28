package goinfromania.view;

import goinfromania.setting.GamePad;
import goinfromania.setting.Setting;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingViewGamePad extends SettingView {
	
	private GamePadTextField textFieldKeyStart,
		textFieldKeyMoveNorth,
		textFieldKeyMoveSouth,
		textFieldKeyMoveWest,
		textFieldKeyMoveEast,
		textFieldKeyPigAttak;
	
	public SettingViewGamePad() {
		super();
		
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
		
		JPanel panelForm = new JPanel(new GridLayout(6, 2));
		panelForm.setBorder(BorderFactory.createTitledBorder("Configurer les touches du clavier"));
		getContentPane().add(panelForm, BorderLayout.CENTER);
		
		panelForm.add(new JLabel("Start"));
		this.textFieldKeyStart = new GamePadTextField();
		panelForm.add(this.textFieldKeyStart);
		
		panelForm.add(new JLabel("Direction Nord"));
		this.textFieldKeyMoveNorth = new GamePadTextField();
		panelForm.add(this.textFieldKeyMoveNorth);
		
		panelForm.add(new JLabel("Direcion Sud"));
		this.textFieldKeyMoveSouth = new GamePadTextField();
		panelForm.add(this.textFieldKeyMoveSouth);
		
		panelForm.add(new JLabel("Direction Ouest"));
		this.textFieldKeyMoveWest = new GamePadTextField();
		panelForm.add(this.textFieldKeyMoveWest);
		
		panelForm.add(new JLabel("Direction Est"));
		this.textFieldKeyMoveEast = new GamePadTextField();
		panelForm.add(this.textFieldKeyMoveEast);
		
		panelForm.add(new JLabel("Attaque Goinfre"));
		this.textFieldKeyPigAttak = new GamePadTextField();
		panelForm.add(this.textFieldKeyPigAttak);
	}
	
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
	protected void editChanges(Setting setting) {
		GamePad gamePadFromForm = (GamePad) getSettingFromForm();
		
		GamePad gamePad = (GamePad) setting;
		
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
	
	@Override
	protected boolean checkChanges() {
		return checkUndefined() && checkDuplicates();
	}
	
	private boolean checkUndefined() {
		if (this.textFieldKeyStart.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyMoveNorth.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyMoveSouth.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyMoveWest.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyMoveEast.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyPigAttak.getKeyCode() == KeyEvent.VK_UNDEFINED) {			
			return false;
		}
		
		return true;
	}
	
	private boolean checkDuplicates() {
		GamePadTextField[] tabFields = {
				this.textFieldKeyStart,
				this.textFieldKeyMoveNorth,
				this.textFieldKeyMoveSouth,
				this.textFieldKeyMoveWest,
				this.textFieldKeyMoveEast,
				this.textFieldKeyPigAttak
		};
		
		int keyCode1, keyCode2;
		
		for (int i=0; i<tabFields.length; i++) {
			keyCode1 = tabFields[i].getKeyCode();
			
			for (int j=i+1; j<tabFields.length; j++) {
				keyCode2 = tabFields[j].getKeyCode();
				
				if (keyCode1 == keyCode2) {
					return false;
				}
			}
		}
		
		return true;
	}
}
