package com.sasd13.goinfromania.view;

import javax.swing.SwingUtilities;

public class App {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Frame frame = new Frame();

				frame.displayHome();
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
