package main.java.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.java.util.ImageLoader;

public class HomeView extends JPanel {
	
	private BufferedImage image;
	
	public HomeView() {
		super();
		
		this.image = ImageLoader.loadFromPath("home.png");
		
		setLayout(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(this.image, 0, 0, this);
	}
}