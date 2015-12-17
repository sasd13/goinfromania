package main.java.view.setting;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GamePadTextField extends JTextField {
	
	private int keyCode;

	public GamePadTextField() {
		super();
		
		this.keyCode = KeyEvent.VK_UNDEFINED;
		
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
		return this.keyCode;
	}
	
	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}
	
	protected void dispatch(int keyCode) {
		this.keyCode = keyCode;
		
		if (this.keyCode != KeyEvent.VK_UNDEFINED) {
			setText(KeyEvent.getKeyText(this.keyCode));
		} else {
			setText("");
			JOptionPane.showMessageDialog(null, "Entrer une touche valide", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
}
