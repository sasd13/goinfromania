package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import util.ImageLoader;

public class HomeView extends JPanel {

	public HomeView() {
		super();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		BufferedImage image = ImageLoader.loadFromPath("home.png");
		
		g.drawImage(image, 0, 0, this);
	}
}
