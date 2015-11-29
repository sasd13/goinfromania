package goinfromania.view.frame;

import goinfromania.game.Element;
import goinfromania.game.Game;
import goinfromania.game.character.pig.Pig;
import goinfromania.view.DimensionConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameDescriptorPane extends JPanel implements ActionListener {

	private Game game;
	
	private JLabel labelLevel,
		labelScore,
		labelDateCreation,
		labelDateLastUpdate,
		labelPigLife,
		labelPigEnergy;
	
	private JButton buttonContinue, buttonRemove;
	
	public GameDescriptorPane() {
		super(new BorderLayout());
		
		this.game = null;
		
		add(new JLabel("Progression", SwingConstants.CENTER), BorderLayout.NORTH);
		
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, getFont().getSize());
		
		JPanel panelGame = new JPanel(new GridLayout(6, 2));
		add(panelGame, BorderLayout.CENTER);
		
		panelGame.add(new JLabel("Niveau : "));
		this.labelLevel = new JLabel();
		this.labelLevel.setFont(font);
		panelGame.add(this.labelLevel);
		
		panelGame.add(new JLabel("Score : "));
		this.labelScore = new JLabel();
		this.labelScore.setFont(font);
		panelGame.add(this.labelScore);
		
		panelGame.add(new JLabel("Vie : "));
		this.labelPigLife = new JLabel();
		this.labelPigLife.setFont(font);
		panelGame.add(this.labelPigLife);
		
		panelGame.add(new JLabel("Energie : "));
		this.labelPigEnergy = new JLabel();
		this.labelPigEnergy.setFont(font);
		panelGame.add(this.labelPigEnergy);
		
		panelGame.add(new JLabel("Création : "));
		this.labelDateCreation = new JLabel();
		this.labelDateCreation.setFont(font);
		panelGame.add(this.labelDateCreation);
		
		panelGame.add(new JLabel("Mise à jour : "));
		this.labelDateLastUpdate = new JLabel();
		this.labelDateLastUpdate.setFont(font);
		panelGame.add(this.labelDateLastUpdate);
		
		JPanel panelButton = new JPanel();
		add(panelButton, BorderLayout.SOUTH);
		
		Dimension dimension = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonContinue = new JButton("Continuer");
		this.buttonContinue.setPreferredSize(dimension);
		this.buttonContinue.setFocusable(false);
		this.buttonContinue.addActionListener(this);
		panelButton.add(this.buttonContinue);
		
		this.buttonRemove = new JButton("Supprimer");
		this.buttonRemove.setPreferredSize(dimension);
		this.buttonRemove.setFocusable(false);
		this.buttonRemove.addActionListener(this);
		panelButton.add(this.buttonRemove);
	}
	
	public void bind(Game game) {
		this.game = game;
		
		this.labelLevel.setText(String.valueOf(game.getLevel()));
		this.labelScore.setText(String.valueOf(game.getScore()));
		for (Element element : game.getElements()) {
			if ("PIG".equalsIgnoreCase(element.getClass().getSimpleName())) {
				Pig pig = (Pig) element;
				
				this.labelPigLife.setText(String.valueOf(pig.getLife()));
				this.labelPigEnergy.setText(String.valueOf(pig.getEnergy()));
				
				break;
			}
		}
		this.labelDateCreation.setText(String.valueOf(game.getDateLastUpdate()));
		this.labelDateLastUpdate.setText(String.valueOf(game.getDateLastUpdate()));
	}
	
	public void clear() {
		this.game = null;
		
		this.labelLevel.setText("");
		this.labelScore.setText("");
		this.labelPigLife.setText("");
		this.labelPigEnergy.setText("");
		this.labelDateLastUpdate.setText("");
		this.labelDateCreation.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		//TODO
	}
}
