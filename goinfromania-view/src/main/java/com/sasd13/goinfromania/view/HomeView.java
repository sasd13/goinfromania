package com.sasd13.goinfromania.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.sasd13.goinfromania.util.ImageLoader;

public class HomeView extends JPanel {
	
	private BufferedImage image;
	
	public HomeView() {
		super();
		
		image = ImageLoader.loadFromPath("home.png");
		
		setLayout(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(image, 0, 0, this);
	}
}
