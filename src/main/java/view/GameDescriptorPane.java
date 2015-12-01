package main.java.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.java.bean.Game;
import main.java.bean.character.pig.Pig;
import main.java.controller.GameDescriptorController;
import main.java.engine.PigEngine;

public class GameDescriptorPane extends JPanel {
	
	private JLabel labelLevel,
		labelScore,
		labelPigLife,
		labelPigEnergy,
		labelDateCreation,
		labelDateLastUpdate;
	
	private JLabel[] labels;
	
	private JButton[] buttons = {
			new JButton("Continuer"),
			new JButton("Supprimer")
	};
	
	private GameDescriptorController gameDescriptorController;
	
	public GameDescriptorPane() {
		super(new BorderLayout());
		
		createLabelProgress();
		createPanelDescription();
		createPanelButtons();
		setButtonsEnabled(false);
	}
	
	private void createLabelProgress() {
		add(new JLabel("Progression", SwingConstants.CENTER), BorderLayout.NORTH);
	}
	
	private void createPanelDescription() {
		this.labels = new JLabel[6];
		
		JPanel panelGame = new JPanel(new GridLayout(this.labels.length, 2));
		
		addLabelsToPanelGame(panelGame);
		
		add(panelGame, BorderLayout.CENTER);
	}

	private void addLabelsToPanelGame(JPanel panelGame) {
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
					label = "Date mise � jour :";
					
					this.labelDateLastUpdate = new JLabel();
					this.labels[i] = this.labelDateLastUpdate;
					break;
			}
			
			this.labels[i].setFont(font);
			
			panelGame.add(new JLabel(label));
			panelGame.add(this.labels[i]);
		}
	}

	private void createPanelButtons() {
		JPanel panelButton = new JPanel();
		
		addButtonsToPanelButton(panelButton);
		
		add(panelButton, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButton) {
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		String command = null;
		this.gameDescriptorController = new GameDescriptorController(this);
		
		int indice = -1;
		for (JButton button : this.buttons) {
			indice++;
			
			switch (indice) {
				case 0:
					command = "CONTINUE";
					break;
				case 1:
					command = "DELETE";
					break;
			}
			
			button.setPreferredSize(dimension);
			button.setFocusable(false);
			button.setActionCommand(command);
			button.addActionListener(this.gameDescriptorController);
			
			panelButton.add(button);
		}
	}
	
	public void bind(Game game) {
		this.labelLevel.setText(String.valueOf(game.getLevel()));
		this.labelScore.setText(String.valueOf(game.getScore()));
		this.labelDateCreation.setText(String.valueOf(game.getDateLastUpdate()));
		this.labelDateLastUpdate.setText(String.valueOf(game.getDateLastUpdate()));
		
		Pig pig = PigEngine.findPig(game.getElements());
		this.labelPigLife.setText(String.valueOf(pig.getLife()));
		this.labelPigEnergy.setText(String.valueOf(pig.getEnergy()));
		
		this.gameDescriptorController.setGame(game);
		
		setButtonsEnabled(true);
	}
	
	public void clear() {
		clearLabels();
		setButtonsEnabled(false);
	}
	
	private void clearLabels() {
		for (JLabel label : this.labels) {
			label.setText("");
		}
	}
	
	private void setButtonsEnabled(boolean enabled) {
		for (JButton button : this.buttons) {
			button.setEnabled(enabled);
		}
	}
}
