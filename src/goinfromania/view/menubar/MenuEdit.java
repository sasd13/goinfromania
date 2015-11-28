package goinfromania.view.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuEdit extends JMenu implements ActionListener {

	private static final String NAME = "Partie";
	
	private final String ITEM_PAUSE = "Pause / Reprise";
	private final String ITEM_STOP = "Stop";
	private final String ITEM_SAVE = "Sauvegarder";
	
	public MenuEdit() {
		super(NAME);
		
		setMnemonic(KeyEvent.VK_P);
		
		JMenuItem itemPause = new JMenuItem(ITEM_PAUSE);
		itemPause.addActionListener(this);
		itemPause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		add(itemPause);
		
		JMenuItem itemStop = new JMenuItem(ITEM_STOP);
		itemStop.addActionListener(this);
		itemStop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		add(itemStop);
		
		addSeparator();
		
		JMenuItem itemSave = new JMenuItem(ITEM_SAVE);
		itemSave.addActionListener(this);
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		add(itemSave);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		//TODO
	}
}
