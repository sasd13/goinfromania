package main.java;

import javax.swing.SwingUtilities;

import main.java.controller.GameController;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GameController.initialize();
				GameController.startGame();
			}
		});
	}
}
