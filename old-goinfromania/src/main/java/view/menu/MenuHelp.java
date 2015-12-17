package main.java.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import main.java.view.help.GameHelpView;
import main.java.view.help.GamePadHelpView;
import main.java.view.help.HelpView;

public class MenuHelp extends JMenu implements ActionListener {

	public static final String NAME = "Aide";
	
	private final String ITEM_GAME = "Jeu";
	private final String ITEM_GAMEPLAY = "Maniabilité";
	
	public MenuHelp() {
		super(NAME);
		
		setMnemonic(KeyEvent.VK_A);
		
		JMenuItem itemGame = new JMenuItem(ITEM_GAME);
		itemGame.addActionListener(this);
		itemGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
		add(itemGame);
		
		JMenuItem itemGamePlay = new JMenuItem(ITEM_GAMEPLAY);
		itemGamePlay.addActionListener(this);
		itemGamePlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		add(itemGamePlay);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		HelpView helpView;
		
		if (item.getText().compareTo(ITEM_GAMEPLAY) == 0) {
			helpView = new GamePadHelpView();
		} else {
			helpView = new GameHelpView();
		}
		
		helpView.pack();
		helpView.setLocationRelativeTo(null);
		helpView.setVisible(true);
	}
}
