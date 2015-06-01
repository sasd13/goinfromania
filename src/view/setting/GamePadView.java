package view.setting;

import game.setting.GamePad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.DimensionConstants;

public class GamePadView extends SettingView {
	
	private GamePadTextField textFieldKeyStart,
		textFieldKeyMoveNorth,
		textFieldKeyMoveSouth,
		textFieldKeyMoveWest,
		textFieldKeyMoveEast,
		textFieldKeyPigAttak;
	
	public GamePadView() {
		super();
		
		setPreferredSize(new Dimension(DimensionConstants.FRAME_WIDTH, DimensionConstants.FRAME_HEIGHT));
		
		JPanel panelForm = new JPanel(new GridLayout(7, 2));
		panelForm.setBorder(BorderFactory.createTitledBorder("Set keyboard controller touchs"));
		getContentPane().add(panelForm, BorderLayout.CENTER);
		
		panelForm.add(new JLabel("Start"));
		this.textFieldKeyStart = new GamePadTextField();
		panelForm.add(this.textFieldKeyStart);
		
		panelForm.add(new JLabel("Move North"));
		this.textFieldKeyMoveNorth = new GamePadTextField();
		panelForm.add(this.textFieldKeyMoveNorth);
		
		panelForm.add(new JLabel("Move South"));
		this.textFieldKeyMoveSouth = new GamePadTextField();
		panelForm.add(this.textFieldKeyMoveSouth);
		
		panelForm.add(new JLabel("Move West"));
		this.textFieldKeyMoveWest = new GamePadTextField();
		panelForm.add(this.textFieldKeyMoveWest);
		
		panelForm.add(new JLabel("Move Eastt"));
		this.textFieldKeyMoveEast = new GamePadTextField();
		panelForm.add(this.textFieldKeyMoveEast);
		
		panelForm.add(new JLabel("Pig Attak"));
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
	protected boolean editChanges() {
		GamePad gamePad = (GamePad) setting;
		
		if (this.textFieldKeyStart.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyMoveNorth.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyMoveSouth.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyMoveWest.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyMoveEast.getKeyCode() == KeyEvent.VK_UNDEFINED
				|| this.textFieldKeyPigAttak.getKeyCode() == KeyEvent.VK_UNDEFINED) {			
			return false;
		}
		
		gamePad.setKeyStart(this.textFieldKeyStart.getKeyCode());
		gamePad.setKeyMoveNorth(this.textFieldKeyMoveNorth.getKeyCode());
		gamePad.setKeyMoveSouth(this.textFieldKeyMoveSouth.getKeyCode());
		gamePad.setKeyMoveWest(this.textFieldKeyMoveWest.getKeyCode());
		gamePad.setKeyMoveEast(this.textFieldKeyMoveEast.getKeyCode());
		gamePad.setKeyPigAttak(this.textFieldKeyPigAttak.getKeyCode());
		
		return true;
	}
}
