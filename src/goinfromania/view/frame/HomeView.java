package goinfromania.view.frame;

import goinfromania.util.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class HomeView extends JPanel {
	
	private BufferedImage image;
	
	public HomeView() {
		super();
		
		setLayout(null);
		
		this.image = ImageLoader.loadFromPath("home.png");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(this.image, 0, 0, this);
	}
}
