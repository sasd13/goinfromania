package goinfromania.view.frame;

import goinfromania.util.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class HomeView extends JPanel {
	
	public HomeView() {
		super();
		
		setLayout(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		BufferedImage image = ImageLoader.loadFromPath("home.png");
		
		g.drawImage(image, 0, 0, this);
	}
}
