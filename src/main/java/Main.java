package main.java;

import goinfromania.view.frame.GameFrame;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GameFrame.getInstance().displayFrame();
			}
		});
	}
}
