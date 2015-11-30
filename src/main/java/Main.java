package main.java;

import goinfromania.view.frame.Frame;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Frame frame = new Frame();
				
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
