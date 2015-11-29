package goinfromania.view.frame;

import goinfromania.controller.GameController;
import goinfromania.game.Element;
import goinfromania.game.Game;
import goinfromania.game.character.pig.Pig;
import goinfromania.view.DimensionConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameDescriptorPane extends JPanel {

	private GameController gameController;
	
	private JLabel labelLevel,
		labelScore,
		labelPigLife,
		labelPigEnergy,
		labelDateCreation,
		labelDateLastUpdate;
	
	private JLabel[] labels;
	
	public GameDescriptorPane() {
		super(new BorderLayout());
		
		this.gameController = GameController.getInstance();
		
		addLabelProgress();
		addPanelDescription();
		addButtons();
	}
	
	private void addLabelProgress() {
		add(new JLabel("Progression", SwingConstants.CENTER), BorderLayout.NORTH);
	}
	
	private void addPanelDescription() {
		this.labels = new JLabel[6];
		
		JPanel panelGame = new JPanel(new GridLayout(this.labels.length, 2));
		
		String label = null;
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, getFont().getSize());
		
		for (int i=0; i<this.labels.length; i++) {
			switch (i) {
				case 0:
					label = "Niveau :";
					
					this.labelLevel = new JLabel();
					this.labels[i] = this.labelLevel;
					break;
				case 1:
					label = "Score :";
					
					this.labelScore = new JLabel();
					this.labels[i] = this.labelScore;
					break;
				case 2:
					label = "Vie :";
					
					this.labelPigLife = new JLabel();
					this.labels[i] = this.labelPigLife;
					break;
				case 3:
					label = "Energie :";
					
					this.labelPigEnergy = new JLabel();
					this.labels[i] = this.labelPigEnergy;
					break;
				case 4:
					label = "Date creation :";
					
					this.labelDateCreation = new JLabel();
					this.labels[i] = this.labelDateCreation;
					break;
				case 5:
					label = "Date mise à jour :";
					
					this.labelDateLastUpdate = new JLabel();
					this.labels[i] = this.labelDateLastUpdate;
					break;
			}
			
			this.labels[i].setFont(font);
			
			panelGame.add(new JLabel(label));
			panelGame.add(this.labels[i]);
		}
		
		add(panelGame, BorderLayout.CENTER);
	}

	private void addButtons() {
		JPanel panelButton = new JPanel();
		
		JButton[] buttons = {
				new JButton("Continuer"),
				new JButton("Supprimer")
		};
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		for (JButton button : buttons) {
			button.setPreferredSize(dimension);
			button.setFocusable(false);
			button.addActionListener(this.gameController);
			
			panelButton.add(button);
		}
		
		add(panelButton, BorderLayout.SOUTH);
	}
	
	public void bind(Game game) {
		this.labelLevel.setText(String.valueOf(game.getLevel()));
		this.labelScore.setText(String.valueOf(game.getScore()));
		for (Element element : game.getElements()) {
			if ("PIG".equalsIgnoreCase(element.getName())) {
				this.labelPigLife.setText(String.valueOf(((Pig) element).getLife()));
				this.labelPigEnergy.setText(String.valueOf(((Pig) element).getEnergy()));
				
				break;
			}
		}
		this.labelDateCreation.setText(String.valueOf(game.getDateLastUpdate()));
		this.labelDateLastUpdate.setText(String.valueOf(game.getDateLastUpdate()));
	}
	
	public void clear() {
		for (JLabel label : this.labels) {
			label.setText("");
		}
	}
}
