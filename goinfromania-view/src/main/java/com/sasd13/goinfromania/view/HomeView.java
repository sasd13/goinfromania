package com.sasd13.goinfromania.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.sasd13.goinfromania.util.ImageLoader;

public class HomeView extends JPanel {
	
	private static final String IMAGE_PATH = "home.png";
	private static BufferedImage image;
	
	static {
		image = ImageLoader.loadFromPath(IMAGE_PATH);
	}
	
	public HomeView() {
		super();
		
		setLayout(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(image, 0, 0, this);
	}
}
